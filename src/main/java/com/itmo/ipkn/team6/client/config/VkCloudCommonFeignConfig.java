package com.itmo.ipkn.team6.client.config;

import com.itmo.ipkn.team6.exception.VkCloudConflictException;
import com.itmo.ipkn.team6.exception.VkCloudForbiddenException;
import com.itmo.ipkn.team6.exception.VkCloudNotFoundException;
import com.itmo.ipkn.team6.exception.VkCloudUnauthorizedException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VkCloudCommonFeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {

        return (methodKey, response) -> {

            if (response.status() == 401) {

                return new VkCloudUnauthorizedException("Токен от Vk Cloud недействителен. Обновите токен в Vk Cloud и сохраните его в настройках.");

            } else if (response.status() == 403) {

                return new VkCloudForbiddenException("Недостаточно прав для совершения операции.");

            } else if (response.status() == 409) {

                if (methodKey.contains("shutoff")) {
                    return new VkCloudConflictException("ВМ нельзя выключить, она уже выключена.");
                } else if (methodKey.contains("activeVm")) {
                    return new VkCloudConflictException("ВМ нельзя включить, она уже включена.");
                } else {
                    return new VkCloudConflictException("Произошёл конфликт при совершении операции.");
                }

            } else if (response.status() == 404) {

                return new VkCloudNotFoundException("Ошибка при выполнении операции - объект не найден.");

            }

            return new ErrorDecoder.Default().decode(methodKey, response);

        };

    }


}
