package by.shilay.app.service.api;

import by.shilay.app.model.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Discipline create(Discipline discipline);
    List<Discipline> findAll();
    Optional<Discipline> findOne(Long id);
}
