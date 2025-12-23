package com.itmo.ipkn.team6.service.impl;

import com.itmo.ipkn.team6.dto.rest.ThresholdSettingsRequest;
import com.itmo.ipkn.team6.model.ThresholdSetting;
import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.repository.ThresholdSettingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThresholdSettingUserService {

    private final ThresholdSettingRepository thresholdSettingRepository;

    @Transactional
    public List<ThresholdSetting> getSettingsForUser(long userId) {
        return thresholdSettingRepository.findAllByUserId(userId);
    }

    @Transactional
    public void persistSettingsForUser(long userId, ThresholdSettingsRequest thresholdSettingsRequest) {
        List<ThresholdSetting> thresholdSettingList = thresholdSettingsRequest.getSettings().stream()
                .map(it -> mapDtoToEntity(userId, it))
                .toList();
        thresholdSettingRepository.saveAll(thresholdSettingList);
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
