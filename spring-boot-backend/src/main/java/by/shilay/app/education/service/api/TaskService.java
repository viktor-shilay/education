package by.shilay.app.education.service.api;

import by.shilay.app.education.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task create(Task task);
}
