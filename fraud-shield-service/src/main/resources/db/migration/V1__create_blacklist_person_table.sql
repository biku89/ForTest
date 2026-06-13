CREATE TABLE blacklist_person (
                                  id UUID PRIMARY KEY,
                                  pesel VARCHAR(11) NOT NULL,
                                  reason VARCHAR(500) NOT NULL,
                                  active BOOLEAN NOT NULL
);

CREATE UNIQUE INDEX uq_blacklist_person_active_pesel
    ON blacklist_person (pesel)
    WHERE active = true;