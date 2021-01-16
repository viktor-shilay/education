package by.shilay.app.service.impl;

import by.shilay.app.model.Discipline;
import by.shilay.app.repository.DisciplineRepository;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public Discipline create(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    @Override
    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public Optional<Discipline> findOne(Long id) {
        return disciplineRepository.findAllById(id);
    }
}
