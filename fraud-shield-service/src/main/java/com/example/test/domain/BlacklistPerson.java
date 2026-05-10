package com.example.test.domain;

import lombok.Data;

@Data
public class BlacklistPerson {
    private BlacklistPersonId id;
    private Pesel pesel;
    private BlacklistReason reason;
    private boolean active;

    private BlacklistPerson(
            BlacklistPersonId id,
            Pesel pesel,
            BlacklistReason reason,
            boolean active
    ) {
        this.id = id;
        this.pesel = pesel;
        this.reason = reason;
        this.active = active;
    }

    public static BlacklistPerson create(Pesel pesel, BlacklistReason reason) {
        return new BlacklistPerson(
                null,
                pesel,
                reason,
                true
        );
    }

    public static BlacklistPerson restore(
            BlacklistPersonId id,
            Pesel pesel,
            BlacklistReason reason,
            boolean active
    ) {
        return new BlacklistPerson(
                id,
                pesel,
                reason,
                active
        );
    }

    public void deactivate() {
        if (!active) {
            throw new IllegalStateException("Blacklist person is already inactive");
        }

        this.active = false;
    }

    public boolean matches(Pesel pesel) {
        return  active && this.pesel.equals(pesel);
    }


}
