package com.example.test.ui.manageapi.blacklist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddBlacklistPersonRequest (
        @NotBlank
        @Size
        String pesel,
        String reason
) {
}
