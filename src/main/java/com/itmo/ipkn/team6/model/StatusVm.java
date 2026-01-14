package com.itmo.ipkn.team6.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Возможные статусы виртуальной машины. SHUTOFF - выключена. ACTIVE - включена."
)
public enum StatusVm {

    @Schema(description = "ВМ выключена.")
    SHUTOFF,

    @Schema(description = "ВМ активна.")
    ACTIVE

}
