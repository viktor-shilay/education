package by.shilay.app.service.api;

import by.shilay.app.dto.TaskDto;
import by.shilay.app.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task create(Task task);
    List<Task> getAllByMaterial(Long id);
    List<TaskDto> getAllByUserId(Long id);
}
