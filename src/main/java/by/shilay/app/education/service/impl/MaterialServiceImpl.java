package by.shilay.app.education.service.impl;

import by.shilay.app.education.model.Material;
import by.shilay.app.education.repository.MaterialRepository;
import by.shilay.app.education.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Material create(Material material) {
        return materialRepository.save(material);
    }
}
