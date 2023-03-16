package com.example.AppProject.service;

import com.example.AppProject.models.dto.TaskDTO;
import com.example.AppProject.models.entity.Task;
import com.example.AppProject.models.entity.User;

import java.security.Principal;
import java.util.List;

public interface TaskService {

    void createTask(Principal principal, TaskDTO taskDTO);

    User getUserByPrincipal(Principal principal);

    Task getTask(Long id);

    void deleteTask(Long id);

    List<Task> tasks(String title);
}
