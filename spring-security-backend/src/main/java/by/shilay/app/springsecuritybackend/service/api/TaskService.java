package by.shilay.app.springsecuritybackend.service.api;

import by.shilay.app.springsecuritybackend.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();
}
