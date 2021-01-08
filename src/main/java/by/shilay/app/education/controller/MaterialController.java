package by.shilay.app.education.controller;

import by.shilay.app.education.model.Material;
import by.shilay.app.education.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/materials")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public List<Material> getAll(){
        return materialService.findAll();
    }

    @GetMapping("/{id")
    public Optional<Material> getOne(@PathVariable("id") Long id){
        return materialService.findOne(id);
    }

    @PostMapping
    public Material create(@RequestBody Material material){
        return materialService.create(material);
    }

}
