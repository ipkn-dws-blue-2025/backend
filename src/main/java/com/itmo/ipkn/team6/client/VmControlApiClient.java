package com.itmo.ipkn.team6.client;

import com.itmo.ipkn.team6.client.config.VkCloudCommonFeignConfig;
import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Feign Client для управления ВМ в Vk Cloud.
 */
@FeignClient(name = "vmControlFeignClient", url = "https://infra.mail.ru:8774/v2.1", configuration = VkCloudCommonFeignConfig.class)
public interface VmControlApiClient {

    @GetMapping("/servers/detail")
    VmBaseDtoList getVmList(@RequestHeader("X-Auth-Token") String token);

    @PostMapping("/servers/{vm_id}/action")
    void shutoff(@RequestHeader("X-Auth-Token") String token, @PathVariable("vm_id") String vmId, @RequestBody Map<String, Object> body);

    @PostMapping("/servers/{vm_id}/action")
    void activeVm(@RequestHeader("X-Auth-Token") String token, @PathVariable("vm_id") String vmId, @RequestBody Map<String, Object> body);

}
