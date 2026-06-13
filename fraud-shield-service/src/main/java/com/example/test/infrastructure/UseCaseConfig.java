package com.example.test.infrastructure;

import com.example.test.application.blacklist.AddPersonToBlacklistUseCase;
import com.example.test.domain.repository.BlacklistPersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public AddPersonToBlacklistUseCase addPersonToBlacklistUseCase(BlacklistPersonRepository blacklistRepository) {
        return new AddPersonToBlacklistUseCase(blacklistRepository);
    }
}
