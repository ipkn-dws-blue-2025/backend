package com.itmo.ipkn.team6.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itmo.ipkn.team6.model.StatusVm;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * Базовое DTO для ВМ
 */
@Schema(description = "Базовое DTO для ВМ.")
@Data
public class VmBaseDto {

    /**
     * Id ВМ внутри Vk Cloud
     */
    @Schema(description = "Id ВМ внутри Vk Cloud.")
    private String id;

    /**
     * Имя ВМ внутри Vk Cloud
     */
    @Schema(description = "Имя ВМ внутри Vk Cloud.")
    private String name;

    /**
     * Статус ВМ (выключена, активна)
     */
    @Schema(description = "Статус ВМ.")
    private StatusVm status;

    @JsonAlias("tenant_id")
    @Schema(description = "Id проекта, в котором находится ВМ.")
    private String projectId;

}
