package by.shilay.app.education.service.impl;

import by.shilay.app.education.model.Discipline;
import by.shilay.app.education.repository.DisciplineRepository;
import by.shilay.app.education.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Discipline> findAllById(Long id) {
        return disciplineRepository.findAllById(id);
    }
}
