package com.itmo.ipkn.team6.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Список ВМ с базовой информацией о них.")
public class VmBaseDtoList {

    private List<VmBaseDto> servers;

}
