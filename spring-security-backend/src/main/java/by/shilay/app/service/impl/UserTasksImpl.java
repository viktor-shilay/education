package by.shilay.app.service.impl;

import by.shilay.app.config.URLConstants;
import by.shilay.app.model.UserTasks;
import by.shilay.app.service.api.UserTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserTasksImpl implements UserTasksService {

    private final RestTemplate restTemplate;

    @Autowired
    public UserTasksImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void update(UserTasks userTasks) {
        restTemplate.put(URLConstants.USERS_TASKS_URL, userTasks, UserTasks.class);
    }
}
