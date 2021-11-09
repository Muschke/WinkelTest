package be.scruples.scruplesantwerpen.services;

import be.scruples.scruplesantwerpen.domain.Geslacht;

import java.util.List;

public interface GeslachtService {
    List<Geslacht> findAll();
    long create(Geslacht geslacht);
    void delete(Long[] ids);
}
