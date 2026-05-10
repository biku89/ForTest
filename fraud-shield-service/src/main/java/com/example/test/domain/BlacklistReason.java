package com.example.test.domain;

public record BlacklistReason(String value) {
    public BlacklistReason {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Blacklist reason cannot be null or blank");
        }

        if (value.length() > 255) {
            throw new IllegalArgumentException("Blacklist reason cannot exceed 255 characters");
        }
    }
}
