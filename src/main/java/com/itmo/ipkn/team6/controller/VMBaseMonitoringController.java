package com.itmo.ipkn.team6.controller;

import com.itmo.ipkn.team6.dto.VmBaseDtoList;
import com.itmo.ipkn.team6.dto.VmBaseMetricDto;
import com.itmo.ipkn.team6.exception.dto.ErrorDto;
import com.itmo.ipkn.team6.service.VMBaseMonitoringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itmo/ipkn/team6/api")
@Tag(name = "API для базового мониторинга ВМ")
public class VMBaseMonitoringController {

    private final VMBaseMonitoringService vmBaseMonitoringService;

    @GetMapping("/get-list-vms")
    @Operation(
            summary = "Получить список виртуальных машин",
            description = """
                                        \s
                     ### Описание:
                     Возвращает список всех виртуальных машин пользователя из VK Cloud.
                     
                     Каждая ВМ представляет следующим набором характеристик:
                     <ul>
                       <li>Id ВМ внутри Vk Cloud.</li>
                       <li>Имя внутри Vk Cloud.</li>
                       <li>Статус ВМ.</li>
                       <li>Id проекта, в котором она располагается.</li>
                     </ul>
                     

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Список ВМ успешно получен",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VmBaseDtoList.class)
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
                            description = "Недостаточно прав для совершения операции (проверьте правильность ввода параметров).",
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
    public VmBaseDtoList getListOfVms(@RequestHeader("X-User-Id") Long userId) {

        return vmBaseMonitoringService.getListOfVms(userId);

    }

    @Operation(
            summary = "Получить базовые метрики по ВМ.",
            description = """
                                        \s
                     ### Описание:
                     Возвращает метрики по ВМ.
                     <ul>
                       <li>Общая загрузка CPU в %</li>
                       <li>Используемая оперативная память в %</li>
                       <li>Занятое место на диске в %</li>
                       <li>Время сбора метрик</li>
                     </ul>

                    \s""",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Метрика по ВМ успешно получена.",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = VmBaseMetricDto.class)
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
                            description = "Недостаточно прав для совершения операции (проверьте правильность ввода параметров).",
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
    @GetMapping("/get-vm-metric")
    public VmBaseMetricDto getVmBaseDtoMetric(@RequestHeader("X-User-Id") Long userId, @RequestHeader("Project-Id") String projectId, @RequestHeader("Vm-Id") String vmId) {

        return vmBaseMonitoringService.getVmBaseMetric(userId, projectId, vmId);

    }


}
