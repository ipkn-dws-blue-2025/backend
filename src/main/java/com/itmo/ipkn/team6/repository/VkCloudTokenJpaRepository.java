package com.itmo.ipkn.team6.repository;

import com.itmo.ipkn.team6.model.VkCloudToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VkCloudTokenJpaRepository extends JpaRepository<VkCloudToken, Long> {


    Optional<VkCloudToken> findByUserId(Long userId);

}
