package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.client.VmControlApiClient;
import com.itmo.ipkn.team6.exception.VkCloudForbiddenException;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.impl.ServiceEncrypt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VmControlServiceTest {

    @Mock
    private VkCloudTokenJpaRepository vkCloudTokenJpaRepository;

    @Mock
    private VmControlApiClient vmControlApiClient;

    @Mock
    private ServiceEncrypt serviceEncrypt;

    @Mock
    private VmMockDataService vmMockDataService;

    @InjectMocks
    private VmControlService vmControlService;

    @Test
    void shutoffVm_shouldCallApiWhenTokenValid() {
        Long userId = 1L;
        String vmId = "vm-123";
        String encryptedToken = "encrypted";
        String decryptedToken = "valid-token";

        VkCloudToken tokenEntity = mock(VkCloudToken.class);
        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn(decryptedToken);

        vmControlService.shutoffVm(userId, vmId);

        Map<String, Object> expectedBody = new HashMap<>();
        expectedBody.put("os-stop", null);
        verify(vmControlApiClient).shutoff(decryptedToken, vmId, expectedBody);
    }

    @Test
    void shutoffVm_shouldCallMockServiceWhenTokenIsMock() {
        Long userId = 1L;
        String vmId = "vm-123";
        String encryptedToken = "encrypted";

        VkCloudToken tokenEntity = mock(VkCloudToken.class);
        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn("00000");

        vmControlService.shutoffVm(userId, vmId);

        verify(vmMockDataService).shutoffVm(vmId);
        verify(vmControlApiClient, never()).shutoff(any(), any(), any());
    }

    @Test
    void activeVm_shouldCallApiWhenTokenValid() {
        Long userId = 1L;
        String vmId = "vm-123";
        String encryptedToken = "encrypted";
        String decryptedToken = "valid-token";

        VkCloudToken tokenEntity = mock(VkCloudToken.class);
        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn(decryptedToken);

        vmControlService.activeVm(userId, vmId);

        Map<String, Object> expectedBody = new HashMap<>();
        expectedBody.put("os-start", null);
        verify(vmControlApiClient).activeVm(decryptedToken, vmId, expectedBody);
    }

    @Test
    void activeVm_shouldCallMockServiceWhenTokenIsMock() {
        Long userId = 1L;
        String vmId = "vm-123";
        String encryptedToken = "encrypted";

        VkCloudToken tokenEntity = mock(VkCloudToken.class);
        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn("00000");

        vmControlService.activeVm(userId, vmId);

        verify(vmMockDataService).activeVm(vmId);
        verify(vmControlApiClient, never()).activeVm(any(), any(), any());
    }

    @Test
    void shutoffVm_shouldThrowExceptionWhenTokenNotFound() {
        Long userId = 1L;
        String vmId = "vm-123";

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.empty());

        try {
            vmControlService.shutoffVm(userId, vmId);
        } catch (VkCloudForbiddenException e) {
            // expected
        }

        verify(vmControlApiClient, never()).shutoff(any(), any(), any());
        verify(vmMockDataService, never()).shutoffVm(any());
    }

    @Test
    void activeVm_shouldThrowExceptionWhenTokenNotFound() {
        Long userId = 1L;
        String vmId = "vm-123";

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.empty());

        try {
            vmControlService.activeVm(userId, vmId);
        } catch (VkCloudForbiddenException e) {
            // expected
        }

        verify(vmControlApiClient, never()).activeVm(any(), any(), any());
        verify(vmMockDataService, never()).activeVm(any());
    }
}