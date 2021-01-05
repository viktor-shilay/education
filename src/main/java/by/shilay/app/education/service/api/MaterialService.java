package by.shilay.app.education.service.api;

import by.shilay.app.education.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> findAll();
    Material create(Material material);
}
