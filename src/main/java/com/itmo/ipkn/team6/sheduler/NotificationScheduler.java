package com.itmo.ipkn.team6.sheduler;

import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import com.itmo.ipkn.team6.repository.UserJpaRepository;
import com.itmo.ipkn.team6.service.impl.VMBaseMonitoringService;
import com.itmo.ipkn.team6.util.SessionHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationScheduler {


    private final UserJpaRepository userJpaRepository;
    private final VMBaseMonitoringService monitoringService;

    @Scheduled(fixedRateString = "${app.scheduler.interval:10000}")
    public void monitorMetrics() {
        log.info("Start checking for notifications");
        List<User> users = userJpaRepository.findAllById(SessionHolder.activeUserIds);
        for (User user : users) {
            for (MetricThresholdType metricThresholdType : MetricThresholdType.values()) {
                monitoringService.checkMetric(metricThresholdType, user);
            }
        }
    }
}
