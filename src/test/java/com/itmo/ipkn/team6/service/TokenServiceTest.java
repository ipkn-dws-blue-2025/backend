package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.exception.NotFoundToken;
import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.OperatorTokenJpaRepository;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import com.itmo.ipkn.team6.service.impl.ServiceEncrypt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @Mock
    private VkCloudTokenJpaRepository vkCloudTokenJpaRepository;

    @Mock
    private ServiceEncrypt serviceEncrypt;

    @Mock
    private OperatorTokenJpaRepository operatorTokenJpaRepository;

    @InjectMocks
    private TokenService tokenService;

    private final Long USER_ID = 1L;

    private final String PLAIN_TOKEN = "plain_token";
    private final String OLD_TOKEN = "old_plain_token";
    private final String ENCRYPTED_TOKEN = "encrypted_token";
    private final String OLD_ENCRYPTED_TOKEN = "old_encrypted_token";

    private final String JWT_KEY = "test-jwt-secret-key-min-32-chars-long-here";


    @Test
    public void addTokenAdmin_WhenTokenNotExists_ShouldCreateNewToken() {

        //GIVEN
        when(vkCloudTokenJpaRepository.findByUserId(USER_ID)).thenReturn(Optional.empty());
        when(serviceEncrypt.encrypt(PLAIN_TOKEN)).thenReturn(ENCRYPTED_TOKEN);

        VkCloudToken vkCloudToken = new VkCloudToken();
        vkCloudToken.setUserId(USER_ID);
        vkCloudToken.setEncryptedAdminToken(ENCRYPTED_TOKEN);

        when(vkCloudTokenJpaRepository.save(any(VkCloudToken.class))).thenReturn(vkCloudToken);

        //WHEN
        tokenService.addTokenAdmin(USER_ID, PLAIN_TOKEN);

        //THEN
        verify(operatorTokenJpaRepository).deleteByOperatorUserId(USER_ID);
        verify(vkCloudTokenJpaRepository).findByUserId(USER_ID);
        verify(serviceEncrypt).encrypt(PLAIN_TOKEN);
        verify(vkCloudTokenJpaRepository).save(argThat(token -> token.getUserId().equals(USER_ID) && token.getEncryptedAdminToken().equals(ENCRYPTED_TOKEN)));


    }

    @Test
    public void addToken_WhenTokenExists_ShouldChangeToken() {

        //GIVEN
        VkCloudToken oldVkCloudToken = new VkCloudToken();
        oldVkCloudToken.setUserId(USER_ID);
        oldVkCloudToken.setEncryptedAdminToken(OLD_ENCRYPTED_TOKEN);

        when(vkCloudTokenJpaRepository.findByUserId(USER_ID)).thenReturn(Optional.of(oldVkCloudToken));
        when(serviceEncrypt.decrypt(OLD_ENCRYPTED_TOKEN)).thenReturn(OLD_TOKEN);
        when(serviceEncrypt.encrypt(PLAIN_TOKEN)).thenReturn(ENCRYPTED_TOKEN);

        //WHEN
        tokenService.addTokenAdmin(USER_ID, PLAIN_TOKEN);

        //THEN
        verify(operatorTokenJpaRepository).deleteByOperatorUserId(USER_ID);
        verify(vkCloudTokenJpaRepository).findByUserId(USER_ID);
        verify(serviceEncrypt).decrypt(OLD_ENCRYPTED_TOKEN);
        verify(serviceEncrypt).encrypt(PLAIN_TOKEN);
        verify(vkCloudTokenJpaRepository).save(argThat(token -> token.getUserId().equals(USER_ID) && token.getEncryptedAdminToken().equals(ENCRYPTED_TOKEN)));

    }

    @Test
    public void createTokenForOperator_WhenTokenExists_ShouldReturnValidJwt() {

        //GIVEN
        VkCloudToken existingToken = new VkCloudToken();
        existingToken.setUserId(USER_ID);
        when(vkCloudTokenJpaRepository.findByUserId(USER_ID)).thenReturn(Optional.of(existingToken));

        UUID tokenUUID = UUID.randomUUID();
        LocalDateTime expiresAt = LocalDateTime.now();

        var mockedUuid = mockStatic(UUID.class);
        mockedUuid.when(UUID::randomUUID).thenReturn(tokenUUID);
        var mockedLocalDateTime = mockStatic(LocalDateTime.class);
        mockedLocalDateTime.when(LocalDateTime::now).thenReturn(expiresAt);
        tokenService.setJwtKey(JWT_KEY);

        //WHEN
        String jwtToken = tokenService.createTokenForOperator(USER_ID);

        //THEN
        assertThat(jwtToken).isNotEmpty();
        Claims claims = Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(jwtToken)
                .getPayload();
        assertThat(claims.get("admin_id", Long.class)).isEqualTo(USER_ID);
        assertThat(claims.get("experies_at", String.class)).isEqualTo(expiresAt.plusDays(1).toString());


    }

    @Test
    public void createTokenOperator_WhenTokenNotExists() {

        //GIVEN
        when(vkCloudTokenJpaRepository.findByUserId(USER_ID)).thenReturn(Optional.empty());

        //WHEN & THEN
        assertThatThrownBy(() -> tokenService.createTokenForOperator(USER_ID))
                .isInstanceOf(NotFoundToken.class);


    }



}