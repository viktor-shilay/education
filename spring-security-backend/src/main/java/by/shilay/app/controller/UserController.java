package by.shilay.app.controller;

import by.shilay.app.model.User;
import by.shilay.app.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try {
            List<User> users = userService.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("User getAll() method error {}: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
