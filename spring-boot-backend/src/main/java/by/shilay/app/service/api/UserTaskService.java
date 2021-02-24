package by.shilay.app.service.api;

import by.shilay.app.dto.TaskDto;
import by.shilay.app.dto.UserTasksDto;
import by.shilay.app.model.UserTasks;

import java.util.List;

public interface UserTaskService {
    List<UserTasks> getAllByUserId(Long id);
    List<UserTasks> getAllByStudentId(Long id);
    UserTasks getOne(Long userId, Long taskId, Long studentId);
    void create(UserTasks userTasks);
    void update(UserTasksDto userTasksDto);
}
