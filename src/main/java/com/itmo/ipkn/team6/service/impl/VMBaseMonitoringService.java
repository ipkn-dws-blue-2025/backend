package com.itmo.ipkn.team6.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itmo.ipkn.team6.client.VmBaseCloudApiClient;
import com.itmo.ipkn.team6.client.VmMonitoringCloudApiClient;
import com.itmo.ipkn.team6.dto.broker.NotificationMessage;
import com.itmo.ipkn.team6.dto.rest.VmMonitoringResponse;
import com.itmo.ipkn.team6.exception.FailedToConvertException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.MetricsChecker;
import com.itmo.ipkn.team6.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VMBaseMonitoringService implements MetricsChecker {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final NotificationService notificationService;
    private final ServiceEncrypt serviceEncrypt;

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;

    private final VmBaseCloudApiClient vmBaseCloudApiClient;
    private final VmMonitoringCloudApiClient vmMonitoringCloudApiClient;

    @Override
    public void checkMetric(MetricThresholdType metric, User user) {
        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(user.getId()).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        ThresholdSetting setting = user.getSettings().stream().findFirst().orElse(null);

        if (setting != null) {
            VmMonitoringResponse instantUsage = vmMonitoringCloudApiClient.getForInstantUsage(
                    serviceEncrypt.decrypt(cloudToken.getEncryptedAdminToken()),
                    setting.getProjectId(),
                    String.format(metric.getPattern(), setting.getVmId()),
                    setting.getNamespace()
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
        } else {
            log.info("Setting is null for user: {}", user.getId());
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
