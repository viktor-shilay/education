package by.shilay.app.service.impl;

import by.shilay.app.model.Task;
import by.shilay.app.service.api.TaskService;
import by.shilay.app.config.URLConstants;
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

    @Override
    public List<Task> getAllByUser(Long id) {
        return restTemplate.getForObject(URLConstants.TASKS_URL + "/user/" + id, List.class);
    }

    @Override
    public List<Task> getAllByStudent(Long id) {
        return restTemplate.getForObject(URLConstants.TASKS_URL + "/student/" + id, List.class);
    }

    @Override
    public void create(Task task) {
        restTemplate.postForObject(URLConstants.TASKS_URL, task, Task.class);
    }

    @Override
    public void update(Task task) {
        restTemplate.put(URLConstants.TASKS_URL, task, Task.class);
    }
}
