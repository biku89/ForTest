package com.example.test.domain.repository;

import com.example.test.domain.blacklist.BlacklistPerson;
import com.example.test.domain.blacklist.BlacklistPersonId;
import com.example.test.domain.blacklist.Pesel;

import java.util.Optional;

public interface BlacklistPersonRepository {
    void  save(BlacklistPerson person);
    boolean existsActiveByPesel(Pesel pesel);
    Optional<BlacklistPerson> findActiveByPesel(Pesel pesel);
    Optional<BlacklistPerson> findById(BlacklistPersonId id);

    //Dlaczego w domain ? Bo use case będzie mówił "potrzebuję zapisać osobę" a nie będzie wiedział czy zapis idzie do PostreSQL plikum, pamięci czy mocka w teście
}
