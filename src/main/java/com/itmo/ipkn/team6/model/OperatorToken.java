package com.itmo.ipkn.team6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "operator_tokens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperatorToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Тот, кто выдал токен
     */
    @Column(name = "admin_user_id", nullable = false)
    private Long adminUserId;

    /**
     * Оператор, который активировал токен
     */
    @Column(name = "operator_user_id")
    private Long operatorUserId;

    /**
     * Jwt token
     */
    @Column(name = "jwt_token", columnDefinition = "TEXT")
    private String jwtToken;

}
