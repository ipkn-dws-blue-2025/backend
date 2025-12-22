package com.itmo.ipkn.team6.service.impl;


import com.itmo.ipkn.team6.client.VmBaseMonitoringApiClient;
import com.itmo.ipkn.team6.dto.VmListResponse;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.exception.UnAuthorizedException;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.MetricsChecker;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VMBaseMonitoringService implements MetricsChecker {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final VmBaseMonitoringApiClient vmBaseMonitoringApiClient;

    public VmListResponse getListOfVms(HttpSession httpSession) {

        Long userId = checkSessionForAuthorized(httpSession);

        VkCloudToken cloudToken = vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(NotFoundToken::new);

        //TODO: добавить расшифровку токена с помощью методов из Spring Security
        //TODO: добавить обработку ошибочных ответов от VK Cloud Api с последующей передачей на фронтенд
        return vmBaseMonitoringApiClient.getVmList(cloudToken.getEncryptedToken());
    }

    private Long checkSessionForAuthorized(HttpSession httpSession) {
        if (httpSession == null || httpSession.getAttribute("userId") == null) {
            throw new UnAuthorizedException();
        }
        return (Long) httpSession.getAttribute("userId");
    }

    public boolean checkRamMetric() {
        return false;
    }

    public boolean checkDiskMetric() {
        return false;
    }

    public boolean checkCpuMetric() {
        return false;
    }

    public boolean checkNetworkMetric() {
        return false;
    }
}
