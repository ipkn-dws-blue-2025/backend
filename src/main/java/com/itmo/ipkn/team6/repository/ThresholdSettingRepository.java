package com.itmo.ipkn.team6.repository;

import com.itmo.ipkn.team6.model.ThresholdSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThresholdSettingRepository extends JpaRepository<ThresholdSetting, Long> {

    List<ThresholdSetting> findAllByUserId(Long userId);
}
