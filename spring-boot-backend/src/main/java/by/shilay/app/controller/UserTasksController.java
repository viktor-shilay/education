package by.shilay.app.controller;

import by.shilay.app.dto.UserTasksDto;
import by.shilay.app.model.UserTasks;
import by.shilay.app.service.api.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users-tasks")
public class UserTasksController {

    private final UserTaskService userTaskService;

    @Autowired
    public UserTasksController(UserTaskService userTaskService) {
        this.userTaskService = userTaskService;
    }

    @GetMapping("/student/{id}")
    public List<UserTasks> getAllByStudentId(@PathVariable("id") Long id){
        return userTaskService.getAllByStudentId(id);
    }

    @GetMapping("/user/{id}")
    public List<UserTasks> getAllByUserId(@PathVariable("id") Long id){
        return userTaskService.getAllByUserId(id);
    }


    @PutMapping
    public void update(@RequestBody UserTasksDto userTasksDto){
        userTaskService.update(userTasksDto);
    }
}
