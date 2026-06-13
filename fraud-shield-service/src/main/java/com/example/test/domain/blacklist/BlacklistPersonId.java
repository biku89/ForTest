package com.example.test.domain.blacklist;

import java.util.UUID;

public record BlacklistPersonId(UUID value) {

    public BlacklistPersonId {
        if (value == null) {
            throw new IllegalArgumentException("BlacklistPersonId cannot be null");
        }
    }

    public static BlacklistPersonId generate() {
        return new BlacklistPersonId(UUID.randomUUID());
    }


}
