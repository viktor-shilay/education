package by.shilay.app.controller;

import by.shilay.app.dto.MaterialDto;
import by.shilay.app.model.Material;
import by.shilay.app.service.api.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Material>> getAll(){
        try{
            return new ResponseEntity<>(materialService.findAll(), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Material>> getOne(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(materialService.findOne(id), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<MaterialDto>> getAllByAuthor(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(materialService.findByAuthor(id), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/discipline/{id}")
    public ResponseEntity<List<MaterialDto>> getAllByDiscipline(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(materialService.findByDiscipline(id), HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody MaterialDto materialDto){
        try{
            materialService.create(materialDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
