package com.itmo.ipkn.team6.service.impl;

import com.itmo.ipkn.team6.dto.rest.ThresholdSettingResponse;
import com.itmo.ipkn.team6.dto.rest.ThresholdSettingsRequest;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import com.itmo.ipkn.team6.repository.ThresholdSettingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ThresholdSettingUserServiceTest {

    @Mock
    private ThresholdSettingRepository thresholdSettingRepository;

    private ThresholdSettingUserService thresholdSettingUserService;

    @BeforeEach
    void setUp() {
        thresholdSettingUserService = new ThresholdSettingUserService(thresholdSettingRepository);
    }

    @Test
    void getSettingsForUser_shouldReturnMappedResponses() {
        long userId = 1L;
        ThresholdSetting setting1 = new ThresholdSetting();
        setting1.setId(100L);
        setting1.setMetricType(MetricThresholdType.CPU);
        setting1.setThresholdValue("80.0");
        setting1.setUserId(userId);

        ThresholdSetting setting2 = new ThresholdSetting();
        setting2.setId(101L);
        setting2.setMetricType(MetricThresholdType.RAM);
        setting2.setThresholdValue("90.0");
        setting2.setUserId(userId);

        List<ThresholdSetting> settings = Arrays.asList(setting1, setting2);
        when(thresholdSettingRepository.findAllByUserId(userId)).thenReturn(settings);

        List<ThresholdSettingResponse> result = thresholdSettingUserService.getSettingsForUser(userId);

        assertEquals(2, result.size());

        ThresholdSettingResponse response1 = result.get(0);
        assertEquals(100L, response1.getId());
        assertEquals(MetricThresholdType.CPU, response1.getMetricType());
        assertEquals("80.0", response1.getThresholdValue());
        assertEquals(userId, response1.getUserId());

        ThresholdSettingResponse response2 = result.get(1);
        assertEquals(101L, response2.getId());
        assertEquals(MetricThresholdType.RAM, response2.getMetricType());
        assertEquals("90.0", response2.getThresholdValue());
        assertEquals(userId, response2.getUserId());
    }

    @Test
    void getSettingsForUser_shouldReturnEmptyListWhenNoSettings() {
        long userId = 1L;
        when(thresholdSettingRepository.findAllByUserId(userId)).thenReturn(List.of());

        List<ThresholdSettingResponse> result = thresholdSettingUserService.getSettingsForUser(userId);

        assertTrue(result.isEmpty());
    }

    @Test
    void createSettingsForUser_shouldSaveAllEntities() {
        long userId = 1L;
        String vmId = "vm-123";
        String projectId = "project-456";
        String namespace = "namespace-789";

        ThresholdSettingsRequest.Setting setting1 = new ThresholdSettingsRequest.Setting();
        setting1.setMetricType(MetricThresholdType.CPU);
        setting1.setThresholdValue("85.0");

        ThresholdSettingsRequest.Setting setting2 = new ThresholdSettingsRequest.Setting();
        setting2.setMetricType(MetricThresholdType.DISK_READ);
        setting2.setThresholdValue("75.0");

        ThresholdSettingsRequest request = new ThresholdSettingsRequest();
        request.setSettings(Arrays.asList(setting1, setting2));

        thresholdSettingUserService.createSettingsForUser(userId, vmId, projectId, namespace, request);

        ArgumentCaptor<List<ThresholdSetting>> captor = ArgumentCaptor.forClass(List.class);
        verify(thresholdSettingRepository).saveAll(captor.capture());

        List<ThresholdSetting> savedSettings = captor.getValue();
        assertEquals(2, savedSettings.size());

        ThresholdSetting savedSetting1 = savedSettings.get(0);
        assertEquals(MetricThresholdType.CPU, savedSetting1.getMetricType());
        assertEquals("85.0", savedSetting1.getThresholdValue());
        assertEquals(vmId, savedSetting1.getVmId());
        assertEquals(projectId, savedSetting1.getProjectId());
        assertEquals(namespace, savedSetting1.getNamespace());
        assertEquals(userId, savedSetting1.getUserId());

        ThresholdSetting savedSetting2 = savedSettings.get(1);
        assertEquals(MetricThresholdType.DISK_READ, savedSetting2.getMetricType());
        assertEquals("75.0", savedSetting2.getThresholdValue());
        assertEquals(vmId, savedSetting2.getVmId());
        assertEquals(projectId, savedSetting2.getProjectId());
        assertEquals(namespace, savedSetting2.getNamespace());
        assertEquals(userId, savedSetting2.getUserId());
    }

    @Test
    void changeSettingsForUser_shouldUpdateExistingSettings() {
        long userId = 1L;
        String vmId = "vm-123";
        String projectId = "project-456";
        String namespace = "namespace-789";

        ThresholdSetting existingSetting = new ThresholdSetting();
        existingSetting.setId(100L);
        existingSetting.setMetricType(MetricThresholdType.CPU);
        existingSetting.setThresholdValue("80.0");
        existingSetting.setUserId(userId);

        when(thresholdSettingRepository.findAllByUserId(userId)).thenReturn(List.of(existingSetting));

        ThresholdSettingsRequest.Setting updatedSetting = new ThresholdSettingsRequest.Setting();
        updatedSetting.setMetricType(MetricThresholdType.CPU);
        updatedSetting.setThresholdValue("90.0");

        ThresholdSettingsRequest request = new ThresholdSettingsRequest();
        request.setSettings(List.of(updatedSetting));

        thresholdSettingUserService.changeSettingsForUser(userId, vmId, projectId, namespace, request);

        assertEquals("90.0", existingSetting.getThresholdValue());
        verify(thresholdSettingRepository, never()).save(any());
    }

    @Test
    void changeSettingsForUser_shouldCreateNewSettingWhenNotFound() {
        long userId = 1L;
        String vmId = "vm-123";
        String projectId = "project-456";
        String namespace = "namespace-789";

        ThresholdSetting existingSetting = new ThresholdSetting();
        existingSetting.setId(100L);
        existingSetting.setMetricType(MetricThresholdType.CPU);
        existingSetting.setThresholdValue("80.0");
        existingSetting.setUserId(userId);

        when(thresholdSettingRepository.findAllByUserId(userId)).thenReturn(List.of(existingSetting));

        ThresholdSettingsRequest.Setting newSetting = new ThresholdSettingsRequest.Setting();
        newSetting.setMetricType(MetricThresholdType.RAM);
        newSetting.setThresholdValue("85.0");

        ThresholdSettingsRequest request = new ThresholdSettingsRequest();
        request.setSettings(List.of(newSetting));

        thresholdSettingUserService.changeSettingsForUser(userId, vmId, projectId, namespace, request);

        ArgumentCaptor<ThresholdSetting> captor = ArgumentCaptor.forClass(ThresholdSetting.class);
        verify(thresholdSettingRepository).save(captor.capture());

        ThresholdSetting savedSetting = captor.getValue();
        assertEquals(MetricThresholdType.RAM, savedSetting.getMetricType());
        assertEquals("85.0", savedSetting.getThresholdValue());
        assertEquals(vmId, savedSetting.getVmId());
        assertEquals(projectId, savedSetting.getProjectId());
        assertEquals(namespace, savedSetting.getNamespace());
        assertEquals(userId, savedSetting.getUserId());
    }

    @Test
    void changeSettingsForUser_shouldUpdateExistingAndCreateNew() {
        long userId = 1L;
        String vmId = "vm-123";
        String projectId = "project-456";
        String namespace = "namespace-789";

        ThresholdSetting existingSetting1 = new ThresholdSetting();
        existingSetting1.setId(100L);
        existingSetting1.setMetricType(MetricThresholdType.CPU);
        existingSetting1.setThresholdValue("80.0");
        existingSetting1.setUserId(userId);

        ThresholdSetting existingSetting2 = new ThresholdSetting();
        existingSetting2.setId(101L);
        existingSetting2.setMetricType(MetricThresholdType.RAM);
        existingSetting2.setThresholdValue("70.0");
        existingSetting2.setUserId(userId);

        when(thresholdSettingRepository.findAllByUserId(userId)).thenReturn(Arrays.asList(existingSetting1, existingSetting2));

        ThresholdSettingsRequest.Setting updateSetting = new ThresholdSettingsRequest.Setting();
        updateSetting.setMetricType(MetricThresholdType.CPU);
        updateSetting.setThresholdValue("90.0");

        ThresholdSettingsRequest.Setting newSetting = new ThresholdSettingsRequest.Setting();
        newSetting.setMetricType(MetricThresholdType.DISK_WRITE);
        newSetting.setThresholdValue("75.0");

        ThresholdSettingsRequest request = new ThresholdSettingsRequest();
        request.setSettings(Arrays.asList(updateSetting, newSetting));

        thresholdSettingUserService.changeSettingsForUser(userId, vmId, projectId, namespace, request);

        assertEquals("90.0", existingSetting1.getThresholdValue());

        ArgumentCaptor<ThresholdSetting> captor = ArgumentCaptor.forClass(ThresholdSetting.class);
        verify(thresholdSettingRepository).save(captor.capture());

        ThresholdSetting savedSetting = captor.getValue();
        assertEquals(MetricThresholdType.DISK_WRITE, savedSetting.getMetricType());
        assertEquals("75.0", savedSetting.getThresholdValue());
    }

    @Test
    void deleteSettingsForUser_shouldDeleteAllByIds() {
        long userId = 1L;
        List<Long> idsToDelete = Arrays.asList(100L, 101L, 102L);

        thresholdSettingUserService.deleteSettingsForUser(userId, idsToDelete);

        verify(thresholdSettingRepository).deleteAllByUserIdAndId(userId, 100L);
        verify(thresholdSettingRepository).deleteAllByUserIdAndId(userId, 101L);
        verify(thresholdSettingRepository).deleteAllByUserIdAndId(userId, 102L);
    }

    @Test
    void deleteSettingsForUser_shouldHandleEmptyList() {
        long userId = 1L;
        List<Long> idsToDelete = List.of();

        thresholdSettingUserService.deleteSettingsForUser(userId, idsToDelete);

        verify(thresholdSettingRepository, never()).deleteAllByUserIdAndId(anyLong(), anyLong());
    }
}