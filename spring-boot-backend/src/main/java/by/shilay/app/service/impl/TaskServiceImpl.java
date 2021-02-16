package by.shilay.app.service.impl;

import by.shilay.app.dto.TaskDto;
import by.shilay.app.model.Task;
import by.shilay.app.model.UserTasks;
import by.shilay.app.repository.TaskRepository;
import by.shilay.app.service.api.MaterialService;
import by.shilay.app.service.api.ReviewService;
import by.shilay.app.service.api.TaskService;
import by.shilay.app.service.api.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserTaskService userTaskService;
    private final MaterialService materialService;
    private final ReviewService reviewService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserTaskService userTaskService, MaterialService materialService, ReviewService reviewService) {
        this.taskRepository = taskRepository;
        this.userTaskService = userTaskService;
        this.materialService = materialService;
        this.reviewService = reviewService;
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
    public List<TaskDto> getAllByUserId(Long id) {
        List<UserTasks> userTasks = userTaskService.getAllByUserId(id);
        List<TaskDto> tasks = new ArrayList<>();
        for (UserTasks temp : userTasks) {
            tasks.add(transfertoTaskDto(temp));
        }
        return tasks;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    private TaskDto transfertoTaskDto(UserTasks userTasks){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(userTasks.getTask().getId());
        taskDto.setTaskName(userTasks.getTask().getTaskName());
        taskDto.setCreationDate(userTasks.getTask().getCreationDate());
        taskDto.setUpdateDate(userTasks.getTask().getUpdateDate());
        taskDto.setDueDate(userTasks.getTask().getDueDate());
        taskDto.setDescription(userTasks.getTask().getDescription());
        taskDto.setMaterialName(materialService.findOne(userTasks.getTask().getMaterial().getId()).get().getMaterialName());
        taskDto.setGrade(userTasks.getGrade());
        taskDto.setUserId(userTasks.getUser().getId());
        return taskDto;
    }

}
