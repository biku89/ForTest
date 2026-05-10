package com.example.test;

import com.example.test.domain.BlacklistReason;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BlacklistReasonTest {

    @Test
    void shouldCreateBlacklistReasonWhenValueIsValid() {

        //given
        String value = "3";

        //when
        BlacklistReason reason = new BlacklistReason(value);

        //then
        assertThat(reason.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void shouldThrowExceptionWhenBlacklistReasonIsNullOrBlank(String invalidReason) {
        assertThatThrownBy(() -> new BlacklistReason(invalidReason))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Blacklist reason cannot be null or blank");
    }
}
