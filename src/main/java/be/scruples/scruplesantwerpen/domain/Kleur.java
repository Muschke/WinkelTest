package be.scruples.scruplesantwerpen.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Kleur {
    private final long id;
    @NotBlank @NotEmpty private final String kleur;

    public Kleur(long id, String kleur) {
        this.id = id;
        this.kleur = kleur;
    }

    public long getId() {
        return id;
    }
    public String getKleur() {
        return kleur;
    }
}
