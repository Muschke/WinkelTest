package be.scruples.scruplesantwerpen.services;

import be.scruples.scruplesantwerpen.domain.Geslacht;
import be.scruples.scruplesantwerpen.repositories.GeslachtRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
class DefaultGeslachtService implements GeslachtService {
    private final GeslachtRepository geslachtRepository;

    public DefaultGeslachtService(GeslachtRepository geslachtRepository) {
        this.geslachtRepository = geslachtRepository;
    }

    @Override
    @Transactional
    public List<Geslacht> findAll() {
        return geslachtRepository.findAll();
    }

    @Override
    public long create(Geslacht geslacht) {
        return geslachtRepository.create(geslacht);
    }

    @Override
    public void delete(Long[] ids) {
        geslachtRepository.delete(ids);
    }
}
