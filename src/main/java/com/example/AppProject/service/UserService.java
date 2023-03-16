package com.example.AppProject.service;

import com.example.AppProject.models.dto.UserDTO;
import com.example.AppProject.models.entity.Task;
import com.example.AppProject.models.entity.User;
import com.example.AppProject.models.enums.Role;

import java.security.Principal;
import java.util.List;

public interface UserService {

    void createUser(UserDTO userDTO);
    User getUser(String email);

//    User getUserByPrincipal(Principal principal);
    List<User> list();
    void changeUserRoles(User user, Role role);
    void deleteUserById(Long id);

}
