package by.shilay.app.service.impl;

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

}
