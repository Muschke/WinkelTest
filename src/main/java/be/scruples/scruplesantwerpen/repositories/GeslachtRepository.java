package be.scruples.scruplesantwerpen.repositories;

import be.scruples.scruplesantwerpen.domain.Geslacht;
import java.util.List;

public interface GeslachtRepository {
    List<Geslacht> findAll();
    long create(Geslacht geslacht);
    void delete(Long[] ids);
}
