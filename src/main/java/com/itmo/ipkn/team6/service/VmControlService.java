package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.client.VmControlApiClient;
import com.itmo.ipkn.team6.exception.InvalidJwtTokenException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.exception.VkCloudForbiddenException;
import com.itmo.ipkn.team6.model.OperatorToken;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.impl.ServiceEncrypt;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VmControlService {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final VmControlApiClient vmControlApiClient;
    private final ServiceEncrypt serviceEncrypt;


    public void shutoffVm(Long userId, String vmId) {

        String encryptedToken = getToken(userId);

        String token = serviceEncrypt.decrypt(encryptedToken);

        Map<String, Object> body = new HashMap<>();
        body.put("os-stop", null);

        vmControlApiClient.shutoff(token, vmId, body);

    }


    public void activeVm(Long userId, String vmId) {

        String encryptedToken = getToken(userId);

        String token = serviceEncrypt.decrypt(encryptedToken);

        Map<String, Object> body = new HashMap<>();
        body.put("os-start", null);


        vmControlApiClient.activeVm(token, vmId, body);

    }

    /**
     * Получает токен из БД.
     * Смотрит сначала админский токен, если не находит, то проверяет токен оператора.
     */
    private String getToken(Long userId) {

        Optional<VkCloudToken> vkCloudToken = vkCloudTokenJpaRepository.findByUserId(userId);


        if (vkCloudToken.isPresent()) {

            // тут случай, если пользователь админ
            return vkCloudToken.get().getEncryptedAdminToken();

        }

        throw new VkCloudForbiddenException("Недостаточно прав для выполнения данной операции. Добавьте токен, который подтверждает ваши права администратора.");

    }


}
