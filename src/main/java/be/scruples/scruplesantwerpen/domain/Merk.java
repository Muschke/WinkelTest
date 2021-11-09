package be.scruples.scruplesantwerpen.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Merk {
    private final long id;
    @NotBlank @NotEmpty private final String naam;

    public Merk(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public long getId() {
        return id;
    }
    public String getNaam() {
        return naam;
    }
}
