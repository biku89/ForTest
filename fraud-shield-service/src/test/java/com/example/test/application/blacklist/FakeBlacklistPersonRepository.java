package com.example.test.application.blacklist;

import com.example.test.domain.blacklist.BlacklistPerson;
import com.example.test.domain.blacklist.BlacklistPersonId;
import com.example.test.domain.blacklist.Pesel;
import com.example.test.domain.repository.BlacklistPersonRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeBlacklistPersonRepository implements BlacklistPersonRepository {

    private final Map<BlacklistPersonId, BlacklistPerson> persons = new HashMap<>();

    @Override
    public void save(BlacklistPerson person) {
        persons.put(person.getId(), person);

    }

    @Override
    public boolean existsActiveByPesel(Pesel pesel) {
        return persons.values().stream().anyMatch(person -> person.matches(pesel));
    }

    @Override
    public Optional<BlacklistPerson> findActiveByPesel(Pesel pesel) {
        return persons.values()
                .stream()
                .filter(blacklistPerson -> blacklistPerson.matches(pesel))
                .findFirst();
    }

    @Override
    public Optional<BlacklistPerson> findById(BlacklistPersonId id) {
        return Optional.ofNullable(persons.get(id));
    }
}
