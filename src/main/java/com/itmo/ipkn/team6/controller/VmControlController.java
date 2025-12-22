package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.exception.dto.ErrorDto;
import com.itmo.ipkn.team6.service.VmControlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для управления состоянием ВМ в Vk Cloud.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/itmo/ipkn/team6/api/control")
@Tag(name = "API для управления ВМ")
public class VmControlController {

    private final VmControlService vmControlService;

    @Operation(
            summary = "Остановить работу ВМ в Vk Cloud.",
            description = """
                                        \s
                     ### Описание:
                     
                     Останавливает работу ВМ в Vk Cloud.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Запрос принят в обработку.",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Попытка выключить ВМ, когда она уже выключена.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Токен от Vk Cloud недействителен.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Токен пользователя не найден в БД.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Недостаточно прав для совершения операции.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Не найдена данная ВМ.",
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
    @PostMapping("/shutoffVm")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void shutoffVm(@RequestHeader("X-User-Id") Long userId, @RequestHeader("Vm-Id") String vmId) {

        vmControlService.shutoffVm(userId, vmId);

    }

    @Operation(
            summary = "Включить остановленную ВМ в VK Cloud.",
            description = """
                                        \s
                     ### Описание:
                     
                     Включает остановленную ВМ в VK Cloud.

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Запрос принят в обработку.",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Попытка включить ВМ, когда она уже включена.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Токен от Vk Cloud недействителен.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Токен пользователя не найден в БД.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Недостаточно прав для совершения операции.",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorDto.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Не найдена данная ВМ.",
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
    @PostMapping("/activeVm")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void activeVm(@RequestHeader("X-User-Id") Long userId, @RequestHeader("Vm-Id") String vmId) {

        vmControlService.activeVm(userId, vmId);

    }

}
