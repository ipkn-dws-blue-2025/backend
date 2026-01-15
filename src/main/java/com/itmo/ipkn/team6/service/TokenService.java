package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.exception.InvalidJwtTokenException;
import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.OperatorToken;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.OperatorTokenJpaRepository;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.impl.ServiceEncrypt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final ServiceEncrypt serviceEncrypt;

    private final OperatorTokenJpaRepository operatorTokenJpaRepository;

    @Value("${encryption.jwt-key}")
    private String jwtKey;

    public void addTokenAdmin(Long userId, String token) {

        Optional<VkCloudToken> optionalVkCloudToken = vkCloudTokenJpaRepository.findByUserId(userId);

        if (optionalVkCloudToken.isPresent()) {

            VkCloudToken vkCloudToken = optionalVkCloudToken.get();

            String oldToken = serviceEncrypt.decrypt(vkCloudToken.getEncryptedAdminToken());

            if (!oldToken.equals(token)) {

                vkCloudToken.setEncryptedAdminToken(serviceEncrypt.encrypt(token));
                vkCloudTokenJpaRepository.save(vkCloudToken);
            }

        } else {

            VkCloudToken newToken = new VkCloudToken();
            newToken.setUserId(userId);
            newToken.setEncryptedAdminToken(serviceEncrypt.encrypt(token));

            vkCloudTokenJpaRepository.save(newToken);

        }


    }


    public String createTokenForOperator(Long userId) {

        vkCloudTokenJpaRepository.findByUserId(userId).orElseThrow(() -> new NotFoundToken("Ваш токен для Vk Cloud не найден. Пожалуйста, добавьте токен."));

        String tokenId = UUID.randomUUID().toString();
        LocalDateTime expiresAt = LocalDateTime.now().plusDays(1);

        return Jwts.builder()
                .id(tokenId)
                .claim("admin_id", userId)
                .claim("experies_at", expiresAt.toString())
                .expiration(Date.from(expiresAt.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8)))
                .compact();


    }


    public void addTokenOperator(Long userId, String jwtToken) {

        try {

            Claims claims = Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(jwtKey.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(jwtToken)
                    .getPayload();


            Long adminId = claims.get("admin_id", Long.class);

            vkCloudTokenJpaRepository.findByUserId(adminId).orElseThrow(() -> new NotFoundToken("Администратора, который выдал вам токен, не существует в системе."));


            Optional<OperatorToken> optionalOperatorJwtToken = operatorTokenJpaRepository.findByOperatorUserId(userId);

            if (optionalOperatorJwtToken.isPresent()) {

                OperatorToken operatorJwtToken = optionalOperatorJwtToken.get();

                operatorJwtToken.setJwtToken(jwtToken);
                operatorJwtToken.setAdminUserId(adminId);

                operatorTokenJpaRepository.save(operatorJwtToken);

            } else {

                OperatorToken operatorJwtToken = new OperatorToken();
                operatorJwtToken.setOperatorUserId(userId);
                operatorJwtToken.setJwtToken(jwtToken);
                operatorJwtToken.setAdminUserId(adminId);
                operatorTokenJpaRepository.save(operatorJwtToken);


            }

        } catch (ExpiredJwtException e) {

            throw new InvalidJwtTokenException("Срок действия токена истек. Получите новый токен у администратора.");

        } catch (SignatureException e) {

            throw new InvalidJwtTokenException("Неверный токен. Возможна попытка подделки.");

        } catch (JwtException e) {

            throw new InvalidJwtTokenException("Неверный формат токена");

        }


    }


}
