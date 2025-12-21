package com.itmo.ipkn.team6.service;

import com.itmo.ipkn.team6.model.VkCloudToken;
import com.itmo.ipkn.team6.repository.VkCloudTokenJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final VkCloudTokenJpaRepository vkCloudTokenJpaRepository;
    private final ServiceEncrypt serviceEncrypt;

    public void addToken(Long userId, String token) {

        Optional<VkCloudToken> optionalVkCloudToken = vkCloudTokenJpaRepository.findByUserId(userId);

        if (optionalVkCloudToken.isPresent()) {

            VkCloudToken vkCloudToken = optionalVkCloudToken.get();

            String oldToken = serviceEncrypt.decrypt(vkCloudToken.getEncryptedToken());

            if (!oldToken.equals(token)) {

                vkCloudToken.setEncryptedToken(serviceEncrypt.encrypt(token));
                vkCloudTokenJpaRepository.save(vkCloudToken);
            }

        } else {
            VkCloudToken newToken = new VkCloudToken();
            newToken.setUserId(userId);
            newToken.setEncryptedToken(serviceEncrypt.encrypt(token));

            vkCloudTokenJpaRepository.save(newToken);
        }


    }


}
