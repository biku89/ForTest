package com.example.test.infrastructure.blacklist.repository;

import com.example.test.domain.blacklist.BlacklistPerson;
import com.example.test.domain.blacklist.BlacklistPersonId;
import com.example.test.domain.blacklist.BlacklistReason;
import com.example.test.domain.blacklist.Pesel;
import com.example.test.domain.repository.BlacklistPersonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaBlacklistPersonRepository implements BlacklistPersonRepository {

    private final SpringDataBlacklistPersonRepository springDataRepository;

    public JpaBlacklistPersonRepository(SpringDataBlacklistPersonRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public void save(BlacklistPerson person) {
        springDataRepository.save(toJpa(person));
    }

    @Override
    public boolean existsActiveByPesel(Pesel pesel) {
        return springDataRepository.existsByPeselAndActiveTrue(pesel.value());
    }

    @Override
    public Optional<BlacklistPerson> findActiveByPesel(Pesel pesel) {
        return springDataRepository.findByPeselAndActiveTrue(pesel.value())
                .map(this::toDomain);
    }

    @Override
    public Optional<BlacklistPerson> findById(BlacklistPersonId id) {
        return springDataRepository.findById(id.value())
                .map(this::toDomain);
    }

    private BlacklistPerson toDomain(BlacklistPersonJpaEntity entity) {
        return BlacklistPerson.restore(
                new BlacklistPersonId(entity.getId()),
                new Pesel(entity.getPesel()),
                new BlacklistReason(entity.getReason()),
                entity.isActive()
        );
    }


    private BlacklistPersonJpaEntity toJpa(BlacklistPerson person) {
        return new BlacklistPersonJpaEntity(
                person.getId().value(),
                person.getPesel().value(),
                person.getReason().value(),
                person.isActive()
        );
    }
}
