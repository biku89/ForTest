package com.example.test.ui.manageapi.blacklist;

import com.example.test.application.blacklist.AddPersonToBlacklistCommand;
import com.example.test.application.blacklist.AddPersonToBlacklistUseCase;
import com.example.test.domain.blacklist.BlacklistPersonId;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blacklist")
public class BlacklistController {

    private final AddPersonToBlacklistUseCase useCase;

    public BlacklistController(AddPersonToBlacklistUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<AddBlacklistPersonResponse> add(
            @Valid @RequestBody AddBlacklistPersonRequest request
    ) {
        BlacklistPersonId id = useCase.handle(new AddPersonToBlacklistCommand(request.pesel(), request.reason()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new AddBlacklistPersonResponse(id.value()));
    }
}
