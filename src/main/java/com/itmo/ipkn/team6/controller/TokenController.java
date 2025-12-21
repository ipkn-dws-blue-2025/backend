package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.dto.VmBaseMetricDto;
import com.itmo.ipkn.team6.exception.dto.ErrorDto;
import com.itmo.ipkn.team6.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itmo/ipkn/team6/token")
@Tag(name = "API для работы с токеном")
public class TokenController {

    private final TokenService tokenService;

    @Operation(
            summary = "Добавить токен для пользователя.",
            description = """
                                        \s
                     ### Описание:
                     
                     Добавление токена для пользователя.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Токен успешно добавлен.",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Внутрення ошибка сервера.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    )
            }
    )
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addToken(@RequestHeader("X-User-Id") Long userId, @RequestHeader("Token") String token) {

        tokenService.addToken(userId, token);

    }

}
