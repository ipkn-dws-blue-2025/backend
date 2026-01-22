package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.client.VmControlApiClient;
import com.itmo.ipkn.team6.client.VmMonitoringApiClient;
import com.itmo.ipkn.team6.dto.VmBaseDto;
import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import com.itmo.ipkn.team6.dto.VmBaseMetricDto;
import com.itmo.ipkn.team6.dto.VmBaseMetricResponse;
import com.itmo.ipkn.team6.exception.InvalidJwtTokenException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.OperatorToken;
import com.itmo.ipkn.team6.model.StatusVm;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.OperatorTokenJpaRepository;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.impl.ServiceEncrypt;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.security.SignatureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VmMonitoringServiceTest {

    @Mock
    private VkCloudTokenJpaRepository vkCloudTokenJpaRepository;

    @Mock
    private VmControlApiClient vmControlApiClient;

    @Mock
    private VmMonitoringApiClient vmMonitoringApiClient;

    @Mock
    private ServiceEncrypt serviceEncrypt;

    @Mock
    private OperatorTokenJpaRepository operatorTokenJpaRepository;

    @Mock
    private VmMockDataService vmMockDataService;

    private VmMonitoringService vmMonitoringService;

    @BeforeEach
    void setUp() {
        vmMonitoringService = new VmMonitoringService(
                vkCloudTokenJpaRepository,
                vmControlApiClient,
                vmMonitoringApiClient,
                serviceEncrypt,
                operatorTokenJpaRepository,
                vmMockDataService
        );
    }

    @Test
    void getListOfVms_shouldReturnMockDataWhenTokenIsMock() {
        Long userId = 1L;
        String encryptedToken = "encrypted";
        VkCloudToken tokenEntity = mock(VkCloudToken.class);
        VmBaseDtoList expectedList = new VmBaseDtoList();

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn("00000");
        when(vmMockDataService.getMockVmBaseDtoList()).thenReturn(expectedList);

        VmBaseDtoList result = vmMonitoringService.getListOfVms(userId);

        assertEquals(expectedList, result);
        verify(vmControlApiClient, never()).getVmList(anyString());
    }

    @Test
    void getListOfVms_shouldCallApiWhenTokenIsValid() {
        Long userId = 1L;
        String encryptedToken = "encrypted";
        String decryptedToken = "valid-token";
        VkCloudToken tokenEntity = mock(VkCloudToken.class);
        VmBaseDtoList expectedList = new VmBaseDtoList();

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn(decryptedToken);
        when(vmControlApiClient.getVmList(decryptedToken)).thenReturn(expectedList);

        VmBaseDtoList result = vmMonitoringService.getListOfVms(userId);

        assertEquals(expectedList, result);
        verify(vmControlApiClient).getVmList(decryptedToken);
    }


    @Test
    void getVmBaseMetric_shouldProcessApiResponseCorrectly() {
        Long userId = 1L;
        String projectId = "project-1";
        String vmId = UUID.randomUUID().toString();
        String encryptedToken = "encrypted";
        String decryptedToken = "valid-token";
        VkCloudToken tokenEntity = mock(VkCloudToken.class);

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn(decryptedToken);

        VmBaseMetricResponse response = createMockApiResponse(vmId);
        when(vmMonitoringApiClient.getVmBaseMetrics(decryptedToken, projectId, "{vm_uuid=\"" + vmId + "\"}"))
                .thenReturn(response);

        VmBaseMetricDto result = vmMonitoringService.getVmBaseMetric(userId, projectId, vmId);

        assertEquals(25.0, result.getCpuLoadPercent());
        assertEquals(60.0, result.getRamUsedPercent());
        assertEquals(75.0, result.getDiskUsedPercent());
        assertNotNull(result.getTimestamp());
    }

    @Test
    void getVmBaseMetric_shouldCalculateTotalCpuCorrectly() {
        Long userId = 1L;
        String projectId = "project-1";
        String vmId = UUID.randomUUID().toString();
        String encryptedToken = "encrypted";
        String decryptedToken = "valid-token";
        VkCloudToken tokenEntity = mock(VkCloudToken.class);

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn(decryptedToken);

        VmBaseMetricResponse response = createApiResponseWithMultipleMetrics(vmId);
        when(vmMonitoringApiClient.getVmBaseMetrics(decryptedToken, projectId, "{vm_uuid=\"" + vmId + "\"}"))
                .thenReturn(response);

        VmBaseMetricDto result = vmMonitoringService.getVmBaseMetric(userId, projectId, vmId);

        assertEquals(37.5, result.getCpuLoadPercent());
        assertEquals(45.0, result.getRamUsedPercent());
        assertEquals(80.0, result.getDiskUsedPercent());
    }



    @Test
    void getListOfVms_shouldThrowExceptionWhenTokenNotFound() {
        Long userId = 1L;

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.empty());
        when(operatorTokenJpaRepository.findByOperatorUserId(userId)).thenReturn(Optional.empty());

        assertThrows(NotFoundToken.class, () -> vmMonitoringService.getListOfVms(userId));
    }

    @Test
    void getVmBaseMetric_shouldReturnZeroMetricsForShutoffVm() {
        Long userId = 1L;
        String projectId = "project-1";
        String vmId = UUID.randomUUID().toString();
        String encryptedToken = "encrypted";
        VkCloudToken tokenEntity = mock(VkCloudToken.class);

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn("00000");

        VmBaseDtoList mockList = new VmBaseDtoList();
        VmBaseDto shutoffVm = new VmBaseDto();
        shutoffVm.setId(vmId);
        shutoffVm.setStatus(StatusVm.SHUTOFF);
        mockList.setServers(List.of(shutoffVm));

        when(vmMockDataService.getMockVmBaseDtoList()).thenReturn(mockList);

        VmBaseMetricDto result = vmMonitoringService.getVmBaseMetric(userId, projectId, vmId);

        assertEquals(0.0, result.getCpuLoadPercent());
        assertEquals(0.0, result.getRamUsedPercent());
        assertEquals(0.0, result.getDiskUsedPercent());
    }

    @Test
    void getVmBaseMetric_shouldParseValueStringCorrectly() {
        Long userId = 1L;
        String projectId = "project-1";
        String vmId = UUID.randomUUID().toString();
        String encryptedToken = "encrypted";
        String decryptedToken = "valid-token";
        VkCloudToken tokenEntity = mock(VkCloudToken.class);

        when(vkCloudTokenJpaRepository.findByUserId(userId)).thenReturn(Optional.of(tokenEntity));
        when(tokenEntity.getEncryptedAdminToken()).thenReturn(encryptedToken);
        when(serviceEncrypt.decrypt(encryptedToken)).thenReturn(decryptedToken);

        VmBaseMetricResponse response = createApiResponseWithStringValues();
        when(vmMonitoringApiClient.getVmBaseMetrics(decryptedToken, projectId, "{vm_uuid=\"" + vmId + "\"}"))
                .thenReturn(response);

        VmBaseMetricDto result = vmMonitoringService.getVmBaseMetric(userId, projectId, vmId);

        assertEquals(30.5, result.getCpuLoadPercent());
        assertEquals(55.2, result.getRamUsedPercent());
        assertEquals(42.8, result.getDiskUsedPercent());
    }

    private VmBaseMetricResponse createMockApiResponse(String vmId) {
        VmBaseMetricResponse response = new VmBaseMetricResponse();
        VmBaseMetricResponse.MonitoringData data = new VmBaseMetricResponse.MonitoringData();
        List<VmBaseMetricResponse.MonitoringResult> results = new ArrayList<>();

        VmBaseMetricResponse.Metric metric1 = new VmBaseMetricResponse.Metric();
        metric1.setName("cpu_usage_system");
        VmBaseMetricResponse.MonitoringResult result1 = new VmBaseMetricResponse.MonitoringResult();
        result1.setMetric(metric1);
        result1.setValue(List.of("timestamp", "10.0"));
        results.add(result1);

        VmBaseMetricResponse.Metric metric2 = new VmBaseMetricResponse.Metric();
        metric2.setName("cpu_usage_user");
        VmBaseMetricResponse.MonitoringResult result2 = new VmBaseMetricResponse.MonitoringResult();
        result2.setMetric(metric2);
        result2.setValue(List.of("timestamp", "15.0"));
        results.add(result2);

        VmBaseMetricResponse.Metric metric3 = new VmBaseMetricResponse.Metric();
        metric3.setName("mem_used_percent");
        VmBaseMetricResponse.MonitoringResult result3 = new VmBaseMetricResponse.MonitoringResult();
        result3.setMetric(metric3);
        result3.setValue(List.of("timestamp", "60.0"));
        results.add(result3);

        VmBaseMetricResponse.Metric metric4 = new VmBaseMetricResponse.Metric();
        metric4.setName("disk_used_percent");
        VmBaseMetricResponse.MonitoringResult result4 = new VmBaseMetricResponse.MonitoringResult();
        result4.setMetric(metric4);
        result4.setValue(List.of("timestamp", "75.0"));
        results.add(result4);

        data.setResult(results);
        response.setData(data);
        return response;
    }

    private VmBaseMetricResponse createApiResponseWithMultipleMetrics(String vmId) {
        VmBaseMetricResponse response = new VmBaseMetricResponse();
        VmBaseMetricResponse.MonitoringData data = new VmBaseMetricResponse.MonitoringData();
        List<VmBaseMetricResponse.MonitoringResult> results = new ArrayList<>();

        VmBaseMetricResponse.Metric metric1 = new VmBaseMetricResponse.Metric();
        metric1.setName("cpu_usage_system");
        VmBaseMetricResponse.MonitoringResult result1 = new VmBaseMetricResponse.MonitoringResult();
        result1.setMetric(metric1);
        result1.setValue(List.of("timestamp", "12.3"));
        results.add(result1);

        VmBaseMetricResponse.Metric metric2 = new VmBaseMetricResponse.Metric();
        metric2.setName("cpu_usage_user");
        VmBaseMetricResponse.MonitoringResult result2 = new VmBaseMetricResponse.MonitoringResult();
        result2.setMetric(metric2);
        result2.setValue(List.of("timestamp", "25.2"));
        results.add(result2);

        VmBaseMetricResponse.Metric metric3 = new VmBaseMetricResponse.Metric();
        metric3.setName("mem_used_percent");
        VmBaseMetricResponse.MonitoringResult result3 = new VmBaseMetricResponse.MonitoringResult();
        result3.setMetric(metric3);
        result3.setValue(List.of("timestamp", "45.0"));
        results.add(result3);

        VmBaseMetricResponse.Metric metric4 = new VmBaseMetricResponse.Metric();
        metric4.setName("disk_used_percent");
        VmBaseMetricResponse.MonitoringResult result4 = new VmBaseMetricResponse.MonitoringResult();
        result4.setMetric(metric4);
        result4.setValue(List.of("timestamp", "80.0"));
        results.add(result4);

        data.setResult(results);
        response.setData(data);
        return response;
    }

    private VmBaseMetricResponse createApiResponseWithStringValues() {
        VmBaseMetricResponse response = new VmBaseMetricResponse();
        VmBaseMetricResponse.MonitoringData data = new VmBaseMetricResponse.MonitoringData();
        List<VmBaseMetricResponse.MonitoringResult> results = new ArrayList<>();

        VmBaseMetricResponse.Metric metric1 = new VmBaseMetricResponse.Metric();
        metric1.setName("cpu_usage_system");
        VmBaseMetricResponse.MonitoringResult result1 = new VmBaseMetricResponse.MonitoringResult();
        result1.setMetric(metric1);
        result1.setValue(Arrays.asList("1700000000", "12.5"));
        results.add(result1);

        VmBaseMetricResponse.Metric metric2 = new VmBaseMetricResponse.Metric();
        metric2.setName("cpu_usage_user");
        VmBaseMetricResponse.MonitoringResult result2 = new VmBaseMetricResponse.MonitoringResult();
        result2.setMetric(metric2);
        result2.setValue(Arrays.asList("1700000000", "18.0"));
        results.add(result2);

        VmBaseMetricResponse.Metric metric3 = new VmBaseMetricResponse.Metric();
        metric3.setName("mem_used_percent");
        VmBaseMetricResponse.MonitoringResult result3 = new VmBaseMetricResponse.MonitoringResult();
        result3.setMetric(metric3);
        result3.setValue(Arrays.asList("1700000000", "55.2"));
        results.add(result3);

        VmBaseMetricResponse.Metric metric4 = new VmBaseMetricResponse.Metric();
        metric4.setName("disk_used_percent");
        VmBaseMetricResponse.MonitoringResult result4 = new VmBaseMetricResponse.MonitoringResult();
        result4.setMetric(metric4);
        result4.setValue(Arrays.asList("1700000000", "42.8"));
        results.add(result4);

        data.setResult(results);
        response.setData(data);
        return response;
    }
}