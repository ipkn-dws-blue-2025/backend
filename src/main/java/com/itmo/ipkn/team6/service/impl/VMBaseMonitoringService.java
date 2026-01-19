package com.itmo.ipkn.team6.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itmo.ipkn.team6.client.VmBaseCloudApiClient;
import com.itmo.ipkn.team6.client.VmMonitoringCloudApiClient;
import com.itmo.ipkn.team6.dto.broker.NotificationMessage;
import com.itmo.ipkn.team6.dto.rest.VmMonitoringResponse;
import com.itmo.ipkn.team6.exception.FailedToConvertException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import com.itmo.ipkn.team6.repository.ThresholdSettingRepository;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.MetricsChecker;
import com.itmo.ipkn.team6.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VMBaseMonitoringService implements MetricsChecker {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final NotificationService notificationService;
    private final ServiceEncrypt serviceEncrypt;

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final ThresholdSettingRepository thresholdSettingRepository;

    private final VmBaseCloudApiClient vmBaseCloudApiClient;
    private final VmMonitoringCloudApiClient vmMonitoringCloudApiClient;

    @Override
    public void checkMetric(MetricThresholdType metric, Long userId) {
        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        List<ThresholdSetting> userSettings = thresholdSettingRepository.findAllByUserIdAndMetricType(userId, metric);
        ThresholdSetting randomSetting = userSettings.stream().findFirst().orElse(null);

        if (randomSetting != null) {
            for (ThresholdSetting setting : userSettings) {
                log.info("Got settings:\n {} \n", setting);
            }
            ResponseEntity<VmMonitoringResponse> responseResponseEntity = vmMonitoringCloudApiClient.getForInstantUsage(
                    serviceEncrypt.decrypt(cloudToken.getEncryptedAdminToken()),
                    randomSetting.getProjectId(),
                    String.format(metric.getPattern(), randomSetting.getVmId()),
                    randomSetting.getNamespace()
            );
            if (responseResponseEntity.getStatusCode().is2xxSuccessful()) {
                VmMonitoringResponse instantUsage = responseResponseEntity.getBody();

                log.info("Compare settings to instant values for user: {}, for metric type: {}", userId, metric);
                for (VmMonitoringResponse.ResultItem resultItem : instantUsage.getData().getResult()) {
                    List<String> list = resultItem.getValue();
                    String timestamp = list.get(0);
                    String instantValue = list.get(1);
                    Optional<ThresholdSetting> thresholdSetting = userSettings.stream()
                            .filter(it -> it.getMetricType().equals(metric))
                            .findFirst();

                    if (thresholdSetting.isPresent()) {
                        String userValue = thresholdSetting.get().getThresholdValue();
                        log.info("User value: {}", userValue);
                        log.info("Instant value: {}", instantValue);
                        if (userValue.compareTo(instantValue) > 0) {
                            String notificationMessage = createNotificationMessage(
                                    userId, instantValue, Long.parseLong(timestamp), userValue, metric
                            );
                            log.info("Sending notification:\n {}", notificationMessage);
                            notificationService.sendNotification(notificationMessage);
                        } else {
                            log.info("No need to send any notifications");
                        }
                    }
                }
            } else {
                log.warn("VK CLOUD TOKEN IS SPOILED FOR USER: {}", userId);
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
