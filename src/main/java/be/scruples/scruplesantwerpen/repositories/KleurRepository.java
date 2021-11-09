package be.scruples.scruplesantwerpen.repositories;



import be.scruples.scruplesantwerpen.domain.Kleur;
import java.util.List;
import java.util.Optional;

public interface KleurRepository {
    List<Kleur> findAll();
    long create(Kleur kleur);
    void delete(Long[] ids);
    Optional<Kleur> findByNaam(String naam);
    List<Kleur> findByBegin(String beginNaam);
}
