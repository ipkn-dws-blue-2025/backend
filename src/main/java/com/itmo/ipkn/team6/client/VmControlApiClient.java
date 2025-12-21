package com.itmo.ipkn.team6.client;

import com.itmo.ipkn.team6.client.config.VmBaseMonitoringFeignConfig;
import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "vmBaseControlFeignClient", url = "https://infra.mail.ru:8774/v2.1", configuration = VmBaseMonitoringFeignConfig.class)
public interface VmControlApiClient {

    @GetMapping("/servers/detail")
    VmBaseDtoList getVmList(@RequestHeader("X-Auth-Token") String token);

}
