package com.itmo.ipkn.team6.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;

@Service
public class ServiceEncrypt {

    @Value("${encryption.master-password}")
    private String masterPassword;

    @Value("${encryption.salt}")
    private String salt;

    public String encrypt(String message) {

        TextEncryptor textEncryptor = Encryptors.text(masterPassword, salt);
        return textEncryptor.encrypt(message);

    }

    public String decrypt(String encryptedMessage) {

        TextEncryptor textEncryptor = Encryptors.text(masterPassword, salt);
        return textEncryptor.decrypt(encryptedMessage);

    }


}
