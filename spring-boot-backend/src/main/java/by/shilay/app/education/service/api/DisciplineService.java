package by.shilay.app.education.service.api;

import by.shilay.app.education.model.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Discipline create(Discipline discipline);
    List<Discipline> findAll();
    Optional<Discipline> findOne(Long id);
}
