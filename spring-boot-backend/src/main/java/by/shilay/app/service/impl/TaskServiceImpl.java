package by.shilay.app.service.impl;

import by.shilay.app.model.Task;
import by.shilay.app.repository.TaskRepository;
import by.shilay.app.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllByMaterial(Long id) {
        return taskRepository.findAllByMaterialId(id);
    }



    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }
}
