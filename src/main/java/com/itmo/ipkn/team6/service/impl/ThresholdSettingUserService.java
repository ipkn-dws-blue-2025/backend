package com.itmo.ipkn.team6.service.impl;

import com.itmo.ipkn.team6.dto.rest.ThresholdSettingResponse;
import com.itmo.ipkn.team6.dto.rest.ThresholdSettingsRequest;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.repository.ThresholdSettingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThresholdSettingUserService {

    private final ThresholdSettingRepository thresholdSettingRepository;

    @Transactional
    public List<ThresholdSettingResponse> getSettingsForUser(long userId) {
        List<ThresholdSetting> settingsByUser = thresholdSettingRepository.findAllByUserId(userId);
        return settingsByUser.stream()
                .map(it -> {
                    ThresholdSettingResponse response = new ThresholdSettingResponse();
                    response.setId(it.getId());
                    response.setMetricType(it.getMetricType());
                    response.setThresholdValue(it.getThresholdValue());
                    response.setUserId(userId);
                    return response;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public void createSettingsForUser(long userId, ThresholdSettingsRequest thresholdSettingsRequest) {
        List<ThresholdSetting> thresholdSettingList = thresholdSettingsRequest.getSettings().stream()
                .map(it -> mapDtoToEntity(userId, it))
                .toList();
        thresholdSettingRepository.saveAll(thresholdSettingList);
    }

    @Transactional
    public void changeSettingsForUser(long userId, ThresholdSettingsRequest thresholdSettingsRequest) {
        List<ThresholdSetting> existingSettings = thresholdSettingRepository.findAllByUserId(userId);

        for (var dto : thresholdSettingsRequest.getSettings()) {
            existingSettings.stream()
                    .filter(s -> s.getMetricType() == dto.getMetricType())
                    .findFirst()
                    .ifPresentOrElse(
                            entity -> entity.setThresholdValue(dto.getThresholdValue()),
                            () -> {
                                ThresholdSetting newSetting = mapDtoToEntity(userId, dto);
                                thresholdSettingRepository.save(newSetting);
                            }
                    );
        }
    }

    private ThresholdSetting mapDtoToEntity(long userId, ThresholdSettingsRequest.Setting settingDto) {
        ThresholdSetting thresholdSetting = new ThresholdSetting();

        thresholdSetting.setMetricType(settingDto.getMetricType());
        thresholdSetting.setThresholdValue(settingDto.getThresholdValue());

        User user = new User();
        user.setId(userId);
        thresholdSetting.setUser(user);

        return thresholdSetting;
    }
}
