package by.shilay.app.service.api;

import by.shilay.app.model.Discipline;
import by.shilay.app.model.responseDto.PageResponse;

public interface DisciplineService {
    PageResponse<Discipline> getAll(int page, int size);
}
