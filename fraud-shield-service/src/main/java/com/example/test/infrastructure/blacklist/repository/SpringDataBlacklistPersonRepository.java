package com.example.test.infrastructure.blacklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataBlacklistPersonRepository extends JpaRepository<BlacklistPersonJpaEntity, UUID> {

    boolean existsByPeselAndActiveTrue(String pesel);
    Optional<BlacklistPersonJpaEntity> findByPeselAndActiveTrue(String pesel);
}
