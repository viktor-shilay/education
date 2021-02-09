package by.shilay.app.service.api;

import by.shilay.app.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getAllByDiscipline(Long id);
    List<Material> getAllByAuthor(Long id);
}
