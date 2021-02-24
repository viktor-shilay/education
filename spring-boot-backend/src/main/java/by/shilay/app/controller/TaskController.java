package by.shilay.app.controller;

import by.shilay.app.dto.TaskDto;
import by.shilay.app.model.Task;
import by.shilay.app.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getByTaskId(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.getByTaskId(id), HttpStatus.OK);
    }

    @GetMapping("/material/{id}")
    public ResponseEntity<List<Task>> getAllByMaterial(@PathVariable("id") Long id){
        return new ResponseEntity<>(taskService.getAllByMaterial(id), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public List<TaskDto> getAllByUserId(@PathVariable("id") Long id){
        return taskService.getAllByUserId(id);
    }

    @GetMapping("/student/{id}")
    public List<TaskDto> getAllByStudentId(@PathVariable("id") Long id){
        return taskService.getAllByStudentId(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody TaskDto taskDto){
        try{
            taskService.create(taskDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody TaskDto taskDto){
        try{
            taskService.update(taskDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
