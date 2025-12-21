package com.itmo.ipkn.team6.service;


import com.itmo.ipkn.team6.client.VmControlApiClient;
import com.itmo.ipkn.team6.client.VmMonitoringApiClient;
import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import com.itmo.ipkn.team6.dto.VmBaseMetricDto;
import com.itmo.ipkn.team6.dto.*;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
//TODO: добавить расшифровку токена с помощью методов из Spring Security
public class VMBaseMonitoringService {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final VmControlApiClient vmControlApiClient;
    private final VmMonitoringApiClient vmMonitoringApiClient;
    private final ServiceEncrypt serviceEncrypt;

    public VmBaseDtoList getListOfVms(Long userId) {

        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        String token = serviceEncrypt.decrypt(cloudToken.getEncryptedToken());

        return vmControlApiClient.getVmList(token);

    }


    public VmBaseMetricDto getVmBaseMetric(Long userId, String projectId, String vmId) {

        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        String token = serviceEncrypt.decrypt(cloudToken.getEncryptedToken());

        // {vm_uuid="f6c93c10-7278-4a5c-bcb1-293c6a48c9f6"} - пример query
        String query = "{vm_uuid=\"" + vmId + "\"}";
        VmBaseMetricResponse vmBaseMetricResponse = vmMonitoringApiClient.getVmBaseMetrics(token, projectId, query);


        double cpuSystemPercent = 0;
        double cpuUserPercent = 0;
        double ramUsedPercent = 0;
        double diskUsedPercent = 0;

        double totalCpuPercent;

        for (VmBaseMetricResponse.MonitoringResult result : vmBaseMetricResponse.getData().getResult()) {

            String metricName = result.getMetric().getName();

            String valueStr = result.getValue().get(1).toString();
            double value = Double.parseDouble(valueStr);

            if ("cpu_usage_system".equals(metricName)) {
                cpuSystemPercent = value;
            } else if ("cpu_usage_user".equals(metricName)) {
                cpuUserPercent = value;
            } else if ("mem_used_percent".equals(metricName)) {
                ramUsedPercent = value;
            } else if ("disk_used_percent".equals(metricName)) {
                diskUsedPercent = value;
            }


        }

        totalCpuPercent = cpuSystemPercent + cpuUserPercent;


        return VmBaseMetricDto.builder()
                .cpuLoadPercent(totalCpuPercent)
                .diskUsedPercent(diskUsedPercent)
                .ramUsedPercent(ramUsedPercent)
                .timestamp(LocalDateTime.now())
                .build();

    }


}
