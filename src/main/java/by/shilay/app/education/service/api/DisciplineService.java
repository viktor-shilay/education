package by.shilay.app.education.service.api;

import by.shilay.app.education.model.Discipline;

import java.util.List;

public interface DisciplineService {
    Discipline create(Discipline discipline);
    List<Discipline> findAll();
    List<Discipline> findAllById(Long id);
}
