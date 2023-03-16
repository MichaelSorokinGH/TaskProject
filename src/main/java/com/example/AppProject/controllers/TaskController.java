package com.example.AppProject.controllers;

import com.example.AppProject.models.dto.TaskDTO;
import com.example.AppProject.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/")
    public String apps(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("tasks", taskService.tasks(title));
        model.addAttribute("user", taskService.getUserByPrincipal(principal));
        return "tasks";
    }
    @GetMapping("/task/{id}")
    public String taskInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("task", taskService.getTask(id));
        return "task-info";

    }

    @PostMapping("/task/create")
    public String createTask(Principal principal, TaskDTO taskDTO) {
        taskService.createTask(principal, taskDTO);
        return "redirect:/";
    }

    @PostMapping("/task/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
