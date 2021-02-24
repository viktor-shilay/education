package by.shilay.app.controller;

import by.shilay.app.model.UserTasks;
import by.shilay.app.service.api.UserTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users-tasks")
public class UserTasksController {

    private final UserTasksService userTasksService;

    @Autowired
    public UserTasksController(UserTasksService userTasksService) {
        this.userTasksService = userTasksService;
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody UserTasks userTasks){
        try{
            userTasksService.update(userTasks);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
