package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.client.VmControlApiClient;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VmControlService {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final VmControlApiClient vmControlApiClient;
    private final ServiceEncrypt serviceEncrypt;


    public void shutoffVm(Long userId, String vmId) {

        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        String token = serviceEncrypt.decrypt(cloudToken.getEncryptedToken());

        Map<String, Object> body = new HashMap<>();
        body.put("os-stop", null);

        vmControlApiClient.shutoff(token, vmId, body);

    }


    public void activeVm(Long userId, String vmId) {

        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        String token = serviceEncrypt.decrypt(cloudToken.getEncryptedToken());

        Map<String, Object> body = new HashMap<>();
        body.put("os-start", null);


        vmControlApiClient.activeVm(token, vmId, body);

    }


}
