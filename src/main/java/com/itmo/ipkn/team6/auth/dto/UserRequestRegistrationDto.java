package com.itmo.ipkn.team6.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestRegistrationDto {

    @NotBlank(message = "Имя пользователя не должно быть пустым.")
    private String username;

    @NotBlank(message = "Пароль не должен быть пустым.")
    private String password;

}
