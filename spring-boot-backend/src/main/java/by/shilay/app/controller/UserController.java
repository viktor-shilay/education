package by.shilay.app.controller;

import by.shilay.app.dto.UserDto;
import by.shilay.app.model.User;
import by.shilay.app.service.api.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(required = false) String name){
        try{
            return new ResponseEntity<>(userService.getAllUsers(name), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(userService.getByUserId(id), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("role/{role}")
    public ResponseEntity<List<UserDto>> getUsersByRole(@PathVariable("role") String role){
        try{
            return new ResponseEntity<>(userService.getAllByRole(role), HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        try{
            return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDTO){
        try{
            return new ResponseEntity<>(userService.create(userDTO), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        try{
            return new ResponseEntity<>(userService.update(id, userDto), HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        try{
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (RuntimeException ex){
            throw new RuntimeException(ex);
        }
    }
}
