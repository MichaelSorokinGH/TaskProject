package com.example.AppProject.controllers;

import com.example.AppProject.models.dto.UserDTO;
import com.example.AppProject.models.entity.User;
import com.example.AppProject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(UserDTO userDTO) {
        userService.createUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("tasks", user.getTasks());
        return "user-info";
    }

    @GetMapping("/editaddress")
    public String editaddress(Model model, Principal principal) {
        model.addAttribute("user", userService.getUser(principal.getName()));
        return "editaddress";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
//
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @GetMapping("/helloAdmin")
//    public String securityUrl() {
//        return "helloAdmin";
//    }
//
//    @PreAuthorize("hasAnyAuthority('ROLE_EXECUTOR')")
//    @GetMapping("/helloExecutor")
//    public String securityUrl1() {
//        return "helloExecutor";
//    }
//
//    @PreAuthorize("hasAuthority('ROLE_USER')")
//    @GetMapping("/helloUser")
//    public String securityUrl2() {
//        return "helloUser";
//    }
}