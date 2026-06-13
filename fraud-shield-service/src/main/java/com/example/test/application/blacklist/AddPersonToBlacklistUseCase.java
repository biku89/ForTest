package com.example.test.application.blacklist;

import com.example.test.domain.blacklist.BlacklistPerson;
import com.example.test.domain.blacklist.BlacklistPersonId;
import com.example.test.domain.blacklist.BlacklistReason;
import com.example.test.domain.blacklist.Pesel;
import com.example.test.domain.repository.BlacklistPersonRepository;

public class AddPersonToBlacklistUseCase {

    private final BlacklistPersonRepository blacklistRepository;

    public AddPersonToBlacklistUseCase(BlacklistPersonRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    public BlacklistPersonId handle(AddPersonToBlacklistCommand command) {
        Pesel pesel = new Pesel(command.pesel());
        BlacklistReason reason = new BlacklistReason(command.reason());

        if (blacklistRepository.existsActiveByPesel(pesel)) {
            throw new IllegalStateException("Person with PESEL " + pesel.value() + " is already blacklisted");
        }

        BlacklistPerson person = BlacklistPerson.create(pesel, reason);

        blacklistRepository.save(person);

        return person.getId();
    }
}
