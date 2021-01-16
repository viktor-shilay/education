package by.shilay.app.springsecuritybackend.service.impl;

import by.shilay.app.springsecuritybackend.config.URLConstants;
import by.shilay.app.springsecuritybackend.model.Task;
import by.shilay.app.springsecuritybackend.service.api.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final RestTemplate restTemplate;

    @Autowired
    public TaskServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Task> getAll() {
        try {
            return restTemplate.getForObject(URLConstants.TASKS_URL, List.class);
        } catch (Exception ex) {
            log.error("Task method getAll() error: " + ex);
            throw new RuntimeException(ex);
        }
    }
}
