package com.itmo.ipkn.team6.repository;

import com.itmo.ipkn.team6.model.OperatorToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperatorTokenJpaRepository extends JpaRepository<OperatorToken, Long> {

    Optional<OperatorToken> findByOperatorUserId(Long operatorUserId);

    void deleteByOperatorUserId(Long operatorUserId);

}
