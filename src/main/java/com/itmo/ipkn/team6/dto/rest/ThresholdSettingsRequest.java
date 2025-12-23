package com.itmo.ipkn.team6.dto.rest;

import lombok.*;
import org.springframework.jmx.support.MetricType;

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
        private MetricType metricType;
        private String thresholdValue;
    }
}
