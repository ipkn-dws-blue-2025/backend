package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.dto.rest.ThresholdSettingResponse;
import com.itmo.ipkn.team6.util.Constants;
import com.itmo.ipkn.team6.dto.rest.ThresholdSettingsRequest;
import com.itmo.ipkn.team6.service.impl.ThresholdSettingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.Controller.THRESHOLD_SETTINGS_API)
public class ThresholdSettingUserController {

    private final ThresholdSettingUserService thresholdSettingUserService;

    @GetMapping("/")
    public List<ThresholdSettingResponse> getSettingsForUser(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("Vm-Id") String vmId
    ) {
        return thresholdSettingUserService.getSettingsForUser(userId);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createSettingsForUser(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("Vm-Id") String vmId,
            @RequestHeader("Project-id") String projectId,
            @RequestHeader("Namespace") String namespace,
            @RequestBody ThresholdSettingsRequest thresholdSettingsRequest
    ) {
        thresholdSettingUserService.createSettingsForUser(userId, vmId, projectId, namespace, thresholdSettingsRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> changeSettingsForUser(
            @RequestHeader("X-User-Id") Long userId,
            @RequestHeader("Vm-Id") String vmId,
            @RequestHeader("Project-id") String projectId,
            @RequestHeader("Namespace") String namespace,
            @RequestBody ThresholdSettingsRequest thresholdSettingsRequest
    ) {
        thresholdSettingUserService.changeSettingsForUser(userId, vmId, projectId, namespace, thresholdSettingsRequest);
        return ResponseEntity.ok().build();
    }
}
