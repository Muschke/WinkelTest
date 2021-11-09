package be.scruples.scruplesantwerpen.repositories;


import be.scruples.scruplesantwerpen.domain.Soort;
import java.util.List;
import java.util.Optional;

public interface SoortRepository {
    List<Soort> findAll();
    long create(Soort soort);
    void delete(Long [] ids);
    Optional<Soort> findByNaam(String naam);
    List<Soort> findByBegin(String beginNaam);
}
