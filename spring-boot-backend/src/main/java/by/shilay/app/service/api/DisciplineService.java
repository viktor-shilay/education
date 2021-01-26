package by.shilay.app.service.api;

import by.shilay.app.dto.DisciplineDto;
import by.shilay.app.dto.PageResponse;
import by.shilay.app.model.Discipline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    Discipline create(Discipline discipline);
    PageResponse<DisciplineDto> getAll(int page, int size);
    Optional<Discipline> findOne(Long id);
}
