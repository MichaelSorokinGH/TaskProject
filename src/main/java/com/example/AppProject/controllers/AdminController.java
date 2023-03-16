package com.example.AppProject.controllers;

import com.example.AppProject.models.entity.User;
import com.example.AppProject.models.enums.Role;
import com.example.AppProject.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("users", userServiceImpl.list());
        return "admin";
    }

    @GetMapping("/admin/user/edit/{user}")
    public String userEdit(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @PostMapping("/admin/user/edit")
    public String userEdit(@RequestParam("userId") User user, @RequestParam("role") Role role) {
        userServiceImpl.changeUserRoles(user, role);
        return "redirect:/admin";
    }

    @PostMapping("admin/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.deleteUserById(id);
        return "redirect:/admin";
    }

//    @PostMapping("/admin/user/app/edit{app}")
//    public String appEdit(@PathVariable("app")App app, Model model) {
//        model.addAttribute("app", app);
//
//    }
}



