package by.shilay.app.controller;

import by.shilay.app.model.Material;
import by.shilay.app.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/materials")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/discipline/{id}")
    public List<Material> getAllByDiscipline(@PathVariable("id") Long id){
        return materialService.getAllByDiscipline(id);
    }

    @GetMapping("/author/{id}")
    public List<Material> getAllByAuthor(@PathVariable("id") Long id){
        return materialService.getAllByAuthor(id);
    }

    @PostMapping
    public void create(@RequestBody Material material){
        materialService.create(material);
    }
}
