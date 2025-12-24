package com.itmo.ipkn.team6.repository;

import com.itmo.ipkn.team6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String username);

    boolean existsByName(String username);
}
