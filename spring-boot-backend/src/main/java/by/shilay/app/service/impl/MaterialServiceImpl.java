package by.shilay.app.service.impl;

import by.shilay.app.model.Material;
import by.shilay.app.repository.MaterialRepository;
import by.shilay.app.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Material> findOne(Long id) {
        return materialRepository.findAllById(id);
    }

    @Override
    public Material create(Material material) {
        return materialRepository.save(material);
    }
}
