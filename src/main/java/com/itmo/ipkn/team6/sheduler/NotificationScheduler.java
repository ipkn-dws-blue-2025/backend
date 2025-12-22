package com.itmo.ipkn.team6.sheduler;

import com.itmo.ipkn.team6.repository.UserJpaRepository;
import com.itmo.ipkn.team6.service.NotificationService;
import com.itmo.ipkn.team6.service.impl.VMBaseMonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationScheduler {

    private final NotificationService notificationService;
    private final UserJpaRepository userJpaRepository;
    private final VMBaseMonitoringService monitoringService;

    @Scheduled(fixedRateString = "${app.scheduler.interval:10000}")
    public void monitorMetrics() {
        // userJpaRepository.getSettings()
        if (monitoringService.checkRamMetric()) {
            notificationService.sendNotification("RAM");
        }
        if (monitoringService.checkDiskMetric()) {
            notificationService.sendNotification("DISK");
        }
        if (monitoringService.checkCpuMetric()) {
            notificationService.sendNotification("CPU");
        }
        if (monitoringService.checkNetworkMetric()) {
            notificationService.sendNotification("NETWORK");
        }
    }
}
