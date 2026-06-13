package com.example.test.infrastructure.blacklist.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "blacklist_person")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class BlacklistPersonJpaEntity {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String pesel;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private boolean active;

}
