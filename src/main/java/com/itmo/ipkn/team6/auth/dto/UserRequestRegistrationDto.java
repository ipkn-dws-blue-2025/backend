package com.itmo.ipkn.team6.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestRegistrationDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
