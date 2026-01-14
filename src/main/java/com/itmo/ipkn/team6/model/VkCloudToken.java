package com.itmo.ipkn.team6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vk_cloud_tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VkCloudToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "encrypted_token", columnDefinition = "TEXT")
    private String encryptedToken;

    @Column(name = "user_id")
    private Long userId;

}
