package com.itmo.ipkn.team6.exception.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@Schema(description = "Общий формат ошибок.")
public class ErrorDto {

    @Schema(description = "Время и дата ошибки.")
    private LocalDateTime timestamp;

    @Schema(description = "Сообщение ошибки.")
    private String message;

}
