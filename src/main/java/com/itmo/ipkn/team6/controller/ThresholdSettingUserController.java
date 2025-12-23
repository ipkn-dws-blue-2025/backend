package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.util.Constants;
import com.itmo.ipkn.team6.dto.rest.ThresholdSettingsRequest;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.service.impl.ThresholdSettingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.Controller.BASE_API_PATH)
public class ThresholdSettingUserController {

    private final ThresholdSettingUserService thresholdSettingUserService;

    @GetMapping("/threshold-setting/{userId}")
    public List<ThresholdSetting> getSettingsForUser(@PathVariable long userId) {
        return thresholdSettingUserService.getSettingsForUser(userId);
    }

    @PostMapping("/threshold-setting/{userId}")
    public ResponseEntity<Void> createSettingsForUser(@PathVariable long userId, @RequestBody ThresholdSettingsRequest thresholdSettingsRequest) {
        thresholdSettingUserService.persistSettingsForUser(userId, thresholdSettingsRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/threshold-setting/{userId}")
    public ResponseEntity<Void> changeSettingsForUser(@PathVariable long userId, @RequestBody ThresholdSettingsRequest thresholdSettingsRequest) {
        thresholdSettingUserService.persistSettingsForUser(userId, thresholdSettingsRequest);
        return ResponseEntity.ok().build();
    }
}
