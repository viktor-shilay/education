package by.shilay.app.service.api;

import by.shilay.app.model.Discipline;
import by.shilay.app.model.responseDto.PageResponse;

import java.util.List;

public interface DisciplineService {
    /*PageResponse<Discipline> getAll(int page, int size);*/
    List<Discipline> getAll();
    List<Discipline> getAllByUser(Long id);
    Discipline create(Discipline discipline);
    void update(Long id, Discipline discipline);
}
