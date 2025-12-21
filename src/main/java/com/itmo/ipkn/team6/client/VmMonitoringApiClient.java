package com.itmo.ipkn.team6.client;

import com.itmo.ipkn.team6.client.config.VmBaseMonitoringFeignConfig;
import com.itmo.ipkn.team6.dto.VmBaseMetricResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "vmBaseMonitoringFeignClient", url = "https://cloud.vk.com/monitoring/query/v2", configuration = VmBaseMonitoringFeignConfig.class)
public interface VmMonitoringApiClient {

    @GetMapping("/{projectId}/query?namespace=mcs/vm")
    VmBaseMetricResponse getVmBaseMetrics(@RequestHeader("X-Auth-Token") String token, @PathVariable("projectId") String projectId, @RequestParam("query") String query);

}
