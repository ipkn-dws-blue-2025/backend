package com.itmo.ipkn.team6.exception.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ValidationErrorDto {

    private LocalDateTime timestamp;
    private int status;
    private Map<String, String> validationErrors;

}
