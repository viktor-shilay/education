package by.shilay.app.service.api;

import by.shilay.app.dto.TaskDto;
import by.shilay.app.model.Task;

import java.util.List;

public interface TaskService {
    Task getByTaskId(Long id);
    Task getByName(String name);
    List<Task> findAll();
    void create(TaskDto taskDto);
    void update(TaskDto taskDto);
    List<Task> getAllByMaterial(Long id);
    List<TaskDto> getAllByUserId(Long id);
    List<TaskDto> getAllByStudentId(Long id);
}
