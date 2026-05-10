package com.example.test;

import com.example.test.domain.Pesel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PeselTest {

    @Test
    void shouldCreatePeselWhenValueHasElevenDigits(){
        //given
        String value = "12345678901";

        //when
        Pesel pesel = new Pesel(value);

        //then
        assertThat(pesel.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1234567890", "123456789012", "abcdefghijk"})
    void shouldThrowExceptionWhenPeselIsInvalid(String invalidPesel) {
        assertThatThrownBy(() -> new Pesel(invalidPesel))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid PESEL number");
    }

    @Test
    void shouldNotBeEqualWhenPeselValueAreDifferent() {
        //given
        Pesel first = new Pesel("12345678901");
        Pesel second = new Pesel("10987654321");

        //then
        assertThat(first).isNotEqualTo(second);

    }

}
