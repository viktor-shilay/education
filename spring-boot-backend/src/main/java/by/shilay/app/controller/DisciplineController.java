package by.shilay.app.controller;

import by.shilay.app.model.Discipline;
import by.shilay.app.service.api.DisciplineService;
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
@RequestMapping(value = "/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public List<Discipline> getAll(){
        return disciplineService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Discipline> getOne(@PathVariable("id") Long id){
        return disciplineService.findOne(id);
    }

    @PostMapping
    public Discipline create(@RequestBody Discipline discipline){
        return disciplineService.create(discipline);
    }

}
