package be.scruples.scruplesantwerpen.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Soort {
    private final long id;
    @NotBlank @NotEmpty private final String eigenschap;

    public Soort(long id, String eigenschap) {
        this.id = id;
        this.eigenschap = eigenschap;
    }

    public long getId() {
        return id;
    }

    public String getEigenschap() {
        return eigenschap;
    }
}
