package by.shilay.app.service.api;

import by.shilay.app.model.UserTasks;

import java.util.List;

public interface UserTaskService {
    List<UserTasks> getAllByUserId(Long id);
}
