package com.example.AppProject.service.impl;

import com.example.AppProject.models.dto.TaskDTO;
import com.example.AppProject.models.entity.Task;
import com.example.AppProject.models.entity.User;
import com.example.AppProject.models.enums.Status;
import com.example.AppProject.models.repositories.TaskRepository;
import com.example.AppProject.models.repositories.UserRepository;
import com.example.AppProject.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ObjectMapper mapper;

    public List<Task> tasks(String title) {
        if (title != null) return taskRepository.findByTitle(title);
        return taskRepository.findAll();
    }

    public void createTask(Principal principal, TaskDTO taskDTO) {
        Task task = mapper.convertValue(taskDTO, Task.class);
        task.setCreatedAt(LocalDateTime.now());
        task.setUser(getUserByPrincipal(principal));
        task.setStatus(Status.CREATED);
        taskRepository.save(task);

    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName()).get();
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        User user = task.getUser();
        List<Task> tasks = user.getTasks();
        tasks.remove(task);
        user.setTasks(tasks);
        userRepository.save(user);
        task.setUser(null);
        taskRepository.delete(task);

    }
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(null);
    }
}
