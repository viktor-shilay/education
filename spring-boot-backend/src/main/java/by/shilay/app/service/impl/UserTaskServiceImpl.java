package by.shilay.app.service.impl;

import by.shilay.app.dto.UserTasksDto;
import by.shilay.app.model.UserTasks;
import by.shilay.app.repository.UserTaskRepository;
import by.shilay.app.service.api.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    private final UserTaskRepository userTaskRepository;

    @Autowired
    public UserTaskServiceImpl(UserTaskRepository userTaskRepository) {
        this.userTaskRepository = userTaskRepository;
    }

    @Override
    public List<UserTasks> getAllByUserId(Long id) {
        return userTaskRepository.findAllByUserId(id);
    }

    @Override
    public List<UserTasks> getAllByStudentId(Long id) {
        return userTaskRepository.findAllByStudentId(id);
    }

    @Override
    public UserTasks getOne(Long userId, Long taskId, Long studentId) {
        return userTaskRepository.findByUserIdAndTaskIdAndStudentId(userId, taskId, studentId);
    }

    @Override
    public void create(UserTasks userTasks) {
        userTaskRepository.save(userTasks);
    }

    @Override
    public void update(UserTasksDto userTasksDto) {
        UserTasks userTasks = getOne(userTasksDto.getUserId(), userTasksDto.getTaskId(), userTasksDto.getStudentId());
        userTasks.setGrade(userTasksDto.getGrade());
        userTasks.setStatus(userTasksDto.getStatus());
        userTaskRepository.save(userTasks);
    }
}
