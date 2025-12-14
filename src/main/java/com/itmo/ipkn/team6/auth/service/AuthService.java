package com.itmo.ipkn.team6.auth.service;

import com.itmo.ipkn.team6.auth.dto.UserRequestRegistrationDto;
import com.itmo.ipkn.team6.exception.UserAlreadyExistsException;
import com.itmo.ipkn.team6.model.User;
import com.itmo.ipkn.team6.repository.UserJpaRepository;
import com.itmo.ipkn.team6.service.ServiceEncrypt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final ServiceEncrypt serviceEncrypt;
    private final UserJpaRepository userJpaRepository;

    public void registerUser(UserRequestRegistrationDto userRequestRegistration) {


        boolean isExistsUser = userJpaRepository.existsByName(userRequestRegistration.getUsername());

        if (isExistsUser) {
            throw new UserAlreadyExistsException();
        }

        User user = User.builder()
                .name(userRequestRegistration.getUsername())
                .encryptedPassword(serviceEncrypt.encrypt(userRequestRegistration.getPassword()))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        userJpaRepository.save(user);

    }

}
