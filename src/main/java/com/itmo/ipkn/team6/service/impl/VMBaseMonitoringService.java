package com.itmo.ipkn.team6.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itmo.ipkn.team6.client.VmBaseCloudApiClient;
import com.itmo.ipkn.team6.client.VmMonitoringCloudApiClient;
import com.itmo.ipkn.team6.dto.broker.NotificationMessage;
import com.itmo.ipkn.team6.dto.rest.VmListResponse;
import com.itmo.ipkn.team6.dto.rest.VmMonitoringResponse;
import com.itmo.ipkn.team6.exception.FailedToConvertException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.exception.UnAuthorizedException;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.MetricsChecker;
import com.itmo.ipkn.team6.service.NotificationService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VMBaseMonitoringService implements MetricsChecker {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final NotificationService notificationService;
    private final ServiceEncrypt serviceEncrypt;

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;

    private final VmBaseCloudApiClient vmBaseCloudApiClient;
    private final VmMonitoringCloudApiClient vmMonitoringCloudApiClient;

    @Value("${projectId:unknown}")
    private String projectId;
    @Value("${namespace:unknown}")
    private String namespace;
    @Value("${vmUuid:unknown}")
    private String vmUuid;

    public VmListResponse getListOfVms(HttpSession httpSession) {
        Long userId = checkSessionForAuthorized(httpSession);

        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(NotFoundToken::new);

        //TODO: добавить расшифровку токена с помощью методов из Spring Security
        //TODO: добавить обработку ошибочных ответов от VK Cloud Api с последующей передачей на фронтенд
        return vmBaseCloudApiClient.getVmList(cloudToken.getEncryptedToken());
    }

    private Long checkSessionForAuthorized(HttpSession httpSession) {
        if (httpSession == null || httpSession.getAttribute("userId") == null) {
            throw new UnAuthorizedException();
        }
        return (Long) httpSession.getAttribute("userId");
    }

    @Override
    public void checkMetric(MetricThresholdType metric, User user) {
        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(user.getId()).orElseThrow(NotFoundToken::new);

        VmMonitoringResponse instantUsage = vmMonitoringCloudApiClient.getForInstantUsage(
                serviceEncrypt.decrypt(cloudToken.getEncryptedToken()),
                projectId,
                String.format(metric.getPattern(), vmUuid),
                namespace
        );

        for (VmMonitoringResponse.ResultItem resultItem : instantUsage.getData().getResult()) {
            for (VmMonitoringResponse.ResultItem.ValueItem value : resultItem.getValues()) {
                String instantValue = value.getValue();
                Optional<ThresholdSetting> thresholdSetting = user.getSettings().stream()
                        .filter(it -> it.getMetricType().equals(metric))
                        .findFirst();

                if (thresholdSetting.isPresent()) {
                    String userValue = thresholdSetting.get().getThresholdValue();
                    if (userValue.compareTo(instantValue) > 0) {
                        notificationService.sendNotification(createNotificationMessage(
                                user.getId(), instantValue, value.getTimestamp(), userValue, metric
                            )
                        );
                    }
                }
            }
        }
    }

    private String createNotificationMessage(long userId, String instantValue, long timestamp, String userValue, MetricThresholdType metric) {
        try {
            NotificationMessage message = NotificationMessage.builder()
                    .userId(userId)
                    .instantValue(instantValue)
                    .userValue(userValue)
                    .metric(metric.name())
                    .timestamp(timestamp)
                    .build();

            return objectMapper.writeValueAsString(message);
        } catch (Exception e) {
            throw new FailedToConvertException();
        }
    }
}
