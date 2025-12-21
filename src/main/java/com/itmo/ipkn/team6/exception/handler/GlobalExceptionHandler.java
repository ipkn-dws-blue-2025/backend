package com.itmo.ipkn.team6.exception.handler;

import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.exception.VkCloudForbiddenException;
import com.itmo.ipkn.team6.exception.VkCloudUnauthorizedException;
import com.itmo.ipkn.team6.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundToken.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleNotFoundTokenException(NotFoundToken ex) {

        return ErrorDto.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

    }

    @ExceptionHandler(VkCloudUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDto handleUnauthorizedVkCloudTokenException(VkCloudUnauthorizedException ex) {

        return ErrorDto.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

    }

    @ExceptionHandler(VkCloudForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDto handleVkCloudForbiddenException(VkCloudForbiddenException ex) {

        return ErrorDto.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleRuntimeException(RuntimeException ex) {

        return ErrorDto.builder()
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

    }


}
