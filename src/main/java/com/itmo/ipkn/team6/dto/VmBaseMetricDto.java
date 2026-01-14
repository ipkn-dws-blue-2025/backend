package com.itmo.ipkn.team6.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Schema(description = "Базовое DTO для метрик ВМ.")
public class VmBaseMetricDto {

    @Schema(description = "Общая загрузка CPU в %.")
    private Double cpuLoadPercent;

    @Schema(description = "Используемая оперативная память в %.")
    private Double ramUsedPercent;

    @Schema(description = "Занятое место на основном диске в %.")
    private Double diskUsedPercent;

    @Schema(description = "Время сбора метрик")
    private LocalDateTime timestamp;


}
