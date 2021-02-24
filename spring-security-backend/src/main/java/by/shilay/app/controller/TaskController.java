package by.shilay.app.controller;

import by.shilay.app.service.api.TaskService;
import by.shilay.app.model.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        try {
            List<Task> tasks = taskService.getAll();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Task getAll() method error {}: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> getAllByUser(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(taskService.getAllByUser(id), HttpStatus.OK);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Task>> getAllByStudent(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(taskService.getAllByStudent(id), HttpStatus.OK);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody Task task){
        try{
            taskService.create(task);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody Task task){
        try{
            taskService.update(task);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
