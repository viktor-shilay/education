package by.shilay.app.service.impl;

import by.shilay.app.dto.MaterialDto;
import by.shilay.app.model.Material;
import by.shilay.app.repository.MaterialRepository;
import by.shilay.app.service.api.DisciplineService;
import by.shilay.app.service.api.MaterialService;
import by.shilay.app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final DisciplineService disciplineService;
    private final UserService userService;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository, DisciplineService disciplineService, UserService userService) {
        this.materialRepository = materialRepository;
        this.disciplineService = disciplineService;
        this.userService = userService;
    }

    @Override
    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    @Override
    public Optional<Material> findOne(Long id) {
        return materialRepository.findById(id);
    }

    @Override
    public Material findByName(String name) {
        return materialRepository.findByMaterialName(name);
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
    public void create(MaterialDto materialDto) {
        materialRepository.save(transferToMaterial(materialDto));
    }


    private MaterialDto transferToMaterialDto(Material material){
        MaterialDto materialDto = new MaterialDto();
        materialDto.setId(material.getId());
        materialDto.setMaterialName(material.getMaterialName());
        materialDto.setCreationDate(material.getCreationDate());
        materialDto.setType(material.getType());
        materialDto.setDescription(material.getDescription());
        materialDto.setAuthor(material.getUser().getId());
        materialDto.setDiscipline(disciplineService.findOne(material.getDiscipline().getId()).get().getName());
        return materialDto;
    }

    private Material transferToMaterial(MaterialDto materialDto){
        Material material = new Material();
        material.setMaterialName(materialDto.getMaterialName());
        material.setCreationDate(materialDto.getCreationDate());
        material.setType(materialDto.getType());
        material.setDescription(materialDto.getDescription());
        material.setDiscipline(disciplineService.findByName(materialDto.getDiscipline()));
        material.setUser(userService.getByUserId(materialDto.getAuthor()));
        return material;
    }

    private List<MaterialDto> transferToListDto(List<Material> materials){
        List<MaterialDto> materialDtos = new ArrayList<>();
        for(Material material: materials){
            materialDtos.add(transferToMaterialDto(material));
        }
        return materialDtos;
    }
}
