package com.itmo.ipkn.team6.auth.controller;

import com.itmo.ipkn.team6.auth.dto.UserRequestRegistrationDto;
import com.itmo.ipkn.team6.auth.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/itmo/ipkn/team6/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody @Valid UserRequestRegistrationDto userRequestRegistration) {

        authService.registerUser(userRequestRegistration);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }

}
