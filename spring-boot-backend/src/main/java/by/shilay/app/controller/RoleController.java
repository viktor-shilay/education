package by.shilay.app.controller;

import by.shilay.app.model.Role;
import by.shilay.app.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        try{
            return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role){
        try{
            return new ResponseEntity<>(roleService.create(role), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
