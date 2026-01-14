package com.itmo.ipkn.team6.dto.rest;

import com.itmo.ipkn.team6.model.util.MetricThresholdType;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThresholdSettingResponse {

    private Long id;
    private MetricThresholdType metricType;
    private String thresholdValue;
    private long userId;
}
