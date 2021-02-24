package by.shilay.app.service.api;

import by.shilay.app.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
    List<Task> getAllByUser(Long id);
    List<Task> getAllByStudent(Long id);
    void create(Task task);
    void update(Task task);
}
