package com.itmo.ipkn.team6.dto;

import lombok.Data;

import java.util.List;

@Data
public class VmListResponse {

    private List<VmDto> servers;

}
