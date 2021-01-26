package by.shilay.app.controller;

import by.shilay.app.dto.DisciplineDto;
import by.shilay.app.dto.PageResponse;
import by.shilay.app.model.Discipline;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<PageResponse> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "3") int size){
        return new ResponseEntity<>(disciplineService.getAll(page, size), HttpStatus.OK);
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
