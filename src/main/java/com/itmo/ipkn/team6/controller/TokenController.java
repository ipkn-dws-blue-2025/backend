package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.dto.rest.TokenStatusResponse;
import com.itmo.ipkn.team6.exception.dto.ErrorDto;
import com.itmo.ipkn.team6.service.TokenService;
import com.itmo.ipkn.team6.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.Controller.TOKEN_API)
@Tag(name = "API для работы с токеном")
public class TokenController {

    private final TokenService tokenService;

    @Operation(
            summary = "Добавить токен от VK Cloud.",
            description = """
                                        \s
                     ### Описание:
                     
                     Добавление токена для админа.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Токен успешно добавлен.",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @PostMapping("/add-token-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTokenForAdmin(@RequestHeader("X-User-Id") Long userId, @RequestHeader("Token") String token) {
        tokenService.addTokenAdmin(userId, token);
    }

    @Operation(
            summary = "Добавить токен для оператора.",
            description = """
                                        \s
                     ### Описание:
                     
                     Добавление токена для прав оператора.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Токен успешно добавлен.",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Неверный токен (либо подпись неверна, либо истёк срок и т.д.).",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @PostMapping("/add-token-operator")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTokenForOperator(@RequestHeader("X-User-Id") Long userId, @RequestHeader("Jwt-Token") String jwtToken) {
        tokenService.addTokenOperator(userId, jwtToken);
    }

    @Operation(
            summary = "Статус токена пользователя.",
            description = """
                                        \s
                     ### Описание:
                     
                     Возвращает информацию о наличии токена, его валидности и роли для указанного пользователя.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Статус токена получен.",
                            content = @Content(schema = @Schema(implementation = TokenStatusResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @GetMapping("/status/{userId}")
    public TokenStatusResponse getTokenStatus(@PathVariable Long userId) {
        return tokenService.getTokenStatus(userId);
    }

    @Operation(
            summary = "Создание токена для оператора.",
            description = """
                                        \s
                     ### Описание:
                     
                     Создать jwt token для передачи оператору.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Токен успешно создан.",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутренняя ошибка сервера.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @PostMapping("/create-token-operator")
    public String createTokenForOperator(@RequestHeader("X-User-Id") Long userId) {
        return tokenService.createTokenForOperator(userId);
    }
}
