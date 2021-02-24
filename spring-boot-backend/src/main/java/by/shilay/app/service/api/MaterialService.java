package by.shilay.app.service.api;

import by.shilay.app.dto.MaterialDto;
import by.shilay.app.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    void create(MaterialDto materialDto);
    List<Material> findAll();
    Optional<Material> findOne(Long id);
    Material findByName(String name);
    List<MaterialDto> findByAuthor(Long author);
    List<MaterialDto> findByDiscipline(Long id);
}
