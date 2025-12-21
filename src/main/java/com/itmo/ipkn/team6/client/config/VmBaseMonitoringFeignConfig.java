package com.itmo.ipkn.team6.client.config;

import com.itmo.ipkn.team6.exception.VkCloudForbiddenException;
import com.itmo.ipkn.team6.exception.VkCloudUnauthorizedException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VmBaseMonitoringFeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {

        return (methodKey, response) -> {

            if (response.status() == 401) {

                return new VkCloudUnauthorizedException("Токен от Vk Cloud недействителен. Обновите токен в Vk Cloud и сохраните его в настройках.");

            } else if (response.status() == 403) {

                return new VkCloudForbiddenException("Недостаточно прав для совершения операции.");

            }

            return new ErrorDecoder.Default().decode(methodKey, response);

        };

    }


}
