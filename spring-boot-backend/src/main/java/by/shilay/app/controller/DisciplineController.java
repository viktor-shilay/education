package by.shilay.app.controller;

import by.shilay.app.dto.DisciplineDto;
import by.shilay.app.dto.pageResponse.PageResponse;
import by.shilay.app.model.Discipline;
import by.shilay.app.service.api.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /*@GetMapping
    public ResponseEntity<PageResponse<Discipline>> getAll(@RequestParam(defaultValue = "1") int page,
                                                           @RequestParam(defaultValue = "5") int size){
        try{
            return new ResponseEntity(disciplineService.getAll(page, size), HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }*/

    @GetMapping
    public List<DisciplineDto> getAll(){
        return disciplineService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Discipline>> getOne(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(disciplineService.findOne(id), HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<DisciplineDto>> getAllByUser(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(disciplineService.getAllByUser(id), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping
    public ResponseEntity<Discipline> create(@RequestBody DisciplineDto disciplineDto){
        try{
            return new ResponseEntity<>(disciplineService.create(disciplineDto), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discipline> update(@PathVariable("id") Long id, @RequestBody DisciplineDto disciplineDto){
        try{
            return new ResponseEntity<>(disciplineService.update(id, disciplineDto), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
