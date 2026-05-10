package com.example.test.domain;

public record Pesel(String value) {
        public Pesel {
            if (value == null || value.length() != 11 || !value.matches("\\d{11}")) {
                throw new IllegalArgumentException("Invalid PESEL number");
            }
        }
}
