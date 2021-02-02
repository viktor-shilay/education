package by.shilay.app.service.impl;

import by.shilay.app.dto.MaterialDto;
import by.shilay.app.model.Material;
import by.shilay.app.repository.MaterialRepository;
import by.shilay.app.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<MaterialDto> findByAuthor(Long author) {
        return transferToListDto(materialRepository.findAllByUserId(author));
    }

    @Override
    public List<MaterialDto> findByDiscipline(Long id) {
        return transferToListDto(materialRepository.findAllByDisciplineId(id));
    }

    @Override
    public Material create(Material material) {
        return materialRepository.save(material);
    }


    private MaterialDto transferToMaterialDto(Material material){
        MaterialDto materialDto = new MaterialDto();
        materialDto.setId(material.getId());
        materialDto.setMaterialName(material.getMaterialName());
        materialDto.setCreationDate(material.getCreationDate());
        materialDto.setType(material.getType());
        materialDto.setDescription(material.getDescription());
        return materialDto;
    }

    private List<MaterialDto> transferToListDto(List<Material> materials){
        List<MaterialDto> materialDtos = new ArrayList<>();
        for(Material material: materials){
            materialDtos.add(transferToMaterialDto(material));
        }
        return materialDtos;
    }
}
