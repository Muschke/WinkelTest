package be.scruples.scruplesantwerpen.repositories;


import be.scruples.scruplesantwerpen.domain.Merk;
import java.util.List;
import java.util.Optional;

public interface MerkRepository {
    List<Merk> findAll();
    long create(Merk merk);
    void delete(Long[] ids);
    Optional<Merk> findByNaam(String naam);
    List<Merk> findByBegin(String beginNaam);
}
