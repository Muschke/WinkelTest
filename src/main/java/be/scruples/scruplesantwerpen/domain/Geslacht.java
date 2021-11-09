package be.scruples.scruplesantwerpen.domain;

import be.scruples.scruplesantwerpen.exceptions.OngeldigeWoordkeuzeException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Geslacht {
    private final long id;
    @NotBlank @NotEmpty private final String geslacht;

    public Geslacht(long id, String geslacht) {
        this.id = id;
        this.geslacht = geslacht;
    }

    public long getId() {
        return id;
    }
    public String getGeslacht() {
        return geslacht;
    }

}
