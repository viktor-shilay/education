package by.shilay.app.service.api;

import by.shilay.app.dto.DisciplineDto;
import by.shilay.app.dto.pageResponse.PageResponse;
import by.shilay.app.model.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    /*PageResponse<DisciplineDto> getAll(int page, int size);*/
    List<DisciplineDto> getAll();
    Optional<Discipline> findOne(Long id);
    Discipline findByName(String name);
    List<DisciplineDto> getAllByUser(Long id);
    Discipline create(DisciplineDto disciplineDto);
    Discipline update(Long id, DisciplineDto disciplineDto);
}
