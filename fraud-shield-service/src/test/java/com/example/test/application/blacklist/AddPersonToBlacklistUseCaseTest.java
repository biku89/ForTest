package com.example.test.application.blacklist;

import com.example.test.domain.blacklist.BlacklistPersonId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddPersonToBlacklistUseCaseTest {

    private FakeBlacklistPersonRepository repository;
    private AddPersonToBlacklistUseCase useCase;

    @BeforeEach
    void setUp() {
        repository = new FakeBlacklistPersonRepository();
        useCase = new AddPersonToBlacklistUseCase(repository);
    }

    @Test
    void shouldAddPersonToBlacklist() {
        //given
        AddPersonToBlacklistCommand command = new AddPersonToBlacklistCommand(
                "12345678901",
                "Fraud attempt"
        );

        //when
        BlacklistPersonId id = useCase.handle(command);

        //then
        assertThat(id).isNotNull();
        assertThat(repository.findById(id)).isPresent();

        var savedPerson = repository.findById(id).orElseThrow();

        assertThat(savedPerson.getPesel().value()).isEqualTo("12345678901");
        assertThat(savedPerson.getReason().value()).isEqualTo("Fraud attempt");
        assertThat(savedPerson.isActive()).isTrue();
    }

    @Test
    void shouldThrowExceptionWhenPersonIsAlreadyBlacklisted() {
        //given - dokończ te testy
    }

}
