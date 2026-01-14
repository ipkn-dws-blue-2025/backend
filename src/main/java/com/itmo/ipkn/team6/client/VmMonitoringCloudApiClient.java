package com.itmo.ipkn.team6.client;

import com.itmo.ipkn.team6.dto.rest.VmMonitoringResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@FeignClient(name = "vmMonitoringCloudApiClient", url = "https://cloud.vk.com/monitoring/query/v2/")
public interface VmMonitoringCloudApiClient {

    @GetMapping("/{projectId}/query")
    VmMonitoringResponse getForInstantUsage(
            @RequestHeader("X-Auth-Token") String token,
            @PathVariable String projectId,
            @RequestParam String query,
            @RequestParam String nameSpace
    );

    @GetMapping("/{projectId}/query_range")
    VmMonitoringResponse getForRangeUsage(
            @RequestHeader("X-Auth-Token") String token,
            @PathVariable String projectId,
            @RequestParam String query,
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end,
            @RequestParam String nameSpace
    );
}
