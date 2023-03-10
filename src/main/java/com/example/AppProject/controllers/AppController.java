package com.example.AppProject.controllers;

import com.example.AppProject.models.App;
import com.example.AppProject.service.AppService;
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
public class AppController {
    private final AppService appService;
    @GetMapping("/")
    public String apps(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("apps", appService.listApps(title));
        model.addAttribute("user", appService.getUserByPrincipal(principal));
        return "apps";

    }

    @GetMapping("/app/{id}")
    public String appInfo(@PathVariable Long id, Model model) {
        model.addAttribute("app", appService.getAppById(id));

        return "app-info";

    }

    @PostMapping("app/create")
    public String createApp(Principal principal, App app) {
        appService.saveApp(principal, app) ;
        return "redirect:/";
    }

    @PostMapping("/app/delete/{id}")
    public String deleteApp(@PathVariable Long id) {
        appService.deleteApp(id);
        return "redirect:/";

    }
}
