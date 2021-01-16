package by.shilay.app.service.api;

import by.shilay.app.model.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    Material create(Material material);
    List<Material> findAll();
    Optional<Material> findOne(Long id);
}