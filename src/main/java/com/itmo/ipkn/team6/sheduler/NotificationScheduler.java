package com.itmo.ipkn.team6.sheduler;

import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import com.itmo.ipkn.team6.repository.ThresholdSettingRepository;
import com.itmo.ipkn.team6.repository.UserJpaRepository;
import com.itmo.ipkn.team6.service.impl.VMBaseMonitoringService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationScheduler {

    private final UserJpaRepository userJpaRepository;
    private final ThresholdSettingRepository thresholdSettingRepository;
    private final VMBaseMonitoringService monitoringService;

    @Scheduled(fixedRateString = "${app.scheduler.interval:10000}")
    public void monitorMetrics() {
        log.info("Start checking for notifications");
        List<Long> users = thresholdSettingRepository.findAll().stream()
                .map(ThresholdSetting::getUserId)
                .toList();
        if (users.isEmpty()) {
            log.info("There are no settings");
        }
        for (Long userId : users) {
            log.info("For user: {}", userId);
            for (MetricThresholdType metricThresholdType : MetricThresholdType.values()) {
                monitoringService.checkMetric(metricThresholdType, userId);
            }
        }
    }
}
