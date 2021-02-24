package by.shilay.app.service.impl;

import by.shilay.app.dto.TaskDto;
import by.shilay.app.model.Task;
import by.shilay.app.model.User;
import by.shilay.app.model.UserTasks;
import by.shilay.app.model.UserTasksKey;
import by.shilay.app.repository.TaskRepository;
import by.shilay.app.service.api.MaterialService;
import by.shilay.app.service.api.TaskService;
import by.shilay.app.service.api.UserService;
import by.shilay.app.service.api.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final MaterialService materialService;
    private final UserService userService;
    private final UserTaskService userTaskService;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, MaterialService materialService, UserService userService,
                           UserTaskService userTaskService) {
        this.taskRepository = taskRepository;
        this.materialService = materialService;
        this.userService = userService;
        this.userTaskService = userTaskService;
    }

    @Override
    public Task getByTaskId(Long id) {
        return taskRepository.getOne(id);
    }

    @Override
    public Task getByName(String name) {
        return taskRepository.getByTaskName(name);
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
    public List<TaskDto> getAllByStudentId(Long id) {
        List<UserTasks> userTasks = userTaskService.getAllByStudentId(id);
        List<TaskDto> tasks = new ArrayList<>();
        for(UserTasks temp: userTasks) {
            tasks.add(transfertoTaskDto(temp));
        }
        return tasks;
    }

    @Override
    public void create(TaskDto taskDto) {
        Task task = new Task();
        String taskName = taskDto.getDiscipline() + "-" + new Random().nextInt(9999);
        task.setTaskName(taskName);
        task.setCreationDate(taskDto.getCreationDate());
        task.setUpdateDate(taskDto.getUpdateDate());
        task.setDueDate(taskDto.getDueDate());
        task.setDescription(taskDto.getDescription());
        task.setMaterial(materialService.findByName(taskDto.getMaterialName()));
        taskRepository.save(task);

        String group = taskDto.getGroup();
        if (group != null){
            List<User> students = userService.getAllByGroup(group);
            for (User student : students) {
                UserTasks userTasksStudent = new UserTasks();
                userTasksStudent.setId(new UserTasksKey(taskDto.getUserId(), taskDto.getId(), student.getId()));
                userTasksStudent.setUser(userService.getByUserId(taskDto.getUserId()));
                userTasksStudent.setTask(getByName(taskName));
                userTasksStudent.setStudent(userService.getByUserId(student.getId()));
                userTasksStudent.setStatus("Open");
                userTaskService.create(userTasksStudent);
            }
        }
    }

    @Override
    public void update(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTaskName(taskDto.getTaskName());
        task.setCreationDate(taskDto.getCreationDate());
        task.setUpdateDate(taskDto.getUpdateDate());
        task.setDueDate(taskDto.getDueDate());
        task.setDescription(taskDto.getDescription());
        task.setMaterial(materialService.findByName(taskDto.getMaterialName()));
        taskRepository.save(task);
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
        taskDto.setStudentId(userTasks.getStudent().getId());
        taskDto.setGroup(userTasks.getStudent().getUserGroup().getGroup());
        taskDto.setStudentLastName(userService.getByUserId(taskDto.getStudentId()).getLastName());
        taskDto.setStatus(userTasks.getStatus());
        return taskDto;
    }

}
