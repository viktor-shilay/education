package by.shilay.app.controller;

import by.shilay.app.model.Discipline;
import by.shilay.app.model.responseDto.PageResponse;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/disciplines")
public class DisciplineController {

    private final DisciplineService disciplineService;

    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    public ResponseEntity<Discipline> getAll(@RequestParam (defaultValue = "0") int page,
                                             @RequestParam (defaultValue = "10") int size){
        PageResponse<Discipline> disciplines = disciplineService.getAll(page, size);
        return new ResponseEntity(disciplines, HttpStatus.OK);
    }
}