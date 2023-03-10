package com.example.AppProject.service;

import com.example.AppProject.models.User;
import com.example.AppProject.repositories.AppRepository;
import com.example.AppProject.models.App;
import com.example.AppProject.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AppService {
    private final AppRepository appRepository;

    private final UserRepository userRepository;

    public List<App> listApps(String title) {
        if (title != null) return appRepository.findByTitle(title);
        return appRepository.findAll();
    }
    public void saveApp(Principal principal, App app) {
        app.setUser(getUserByPrincipal(principal));
        log.info("Saving new {}", app);
        appRepository.save(app);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public void deleteApp(Long id) {
        appRepository.deleteById(id);
    }
    public App getAppById(Long id) {
        return appRepository.findById(id).orElseThrow(null);
    }
}





