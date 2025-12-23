package com.itmo.ipkn.team6.dto.rest;

import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThresholdSettingsRequest {

    private List<Setting> settings;

    @Data
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Setting {

        private Long id;
        private MetricThresholdType metricType;
        private String thresholdValue;
    }
}
