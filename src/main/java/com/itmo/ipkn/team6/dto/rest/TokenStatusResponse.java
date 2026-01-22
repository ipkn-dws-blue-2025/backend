package com.itmo.ipkn.team6.dto.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenStatusResponse {

    private boolean hasToken;
    private boolean valid;
    private TokenRole role;
}
