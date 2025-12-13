package com.itmo.ipkn.team6.client;

import com.itmo.ipkn.team6.dto.VmDto;
import com.itmo.ipkn.team6.dto.VmListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "vmBaseMonitoringFeignClient", url = "https://infra.mail.ru:8774/v2.1")
public interface VmBaseMonitoringApiClient {

    @GetMapping("/servers")
    VmListResponse getVmList(@RequestHeader("X-Auth-Token") String token);

}
