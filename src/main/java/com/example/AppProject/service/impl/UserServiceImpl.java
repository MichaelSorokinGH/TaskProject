package com.example.AppProject.service.impl;

import com.example.AppProject.exceptions.CustomException;
import com.example.AppProject.models.dto.UserDTO;
import com.example.AppProject.models.entity.User;
import com.example.AppProject.models.enums.Role;
import com.example.AppProject.models.repositories.TaskRepository;
import com.example.AppProject.models.repositories.UserRepository;
import com.example.AppProject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final TaskRepository taskRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void createUser(UserDTO userDTO) {

        User user = new User();
        String email = userDTO.getEmail();
        userRepository.findByPersonalAccount(userDTO.getPersonalAccount())
                .ifPresent(h -> {
                    throw new CustomException("Пользователь с таким лицевым счётом уже зарегистрирован", HttpStatus.CONFLICT);
                });
        userRepository.findByPhoneNumber(userDTO.getPhoneNumber())
                .ifPresent(h -> {
                    throw new CustomException("Пользователь с таким номером телефона уже зарегистрирован", HttpStatus.CONFLICT);
                });
        if (userDTO.getPhoneNumber() == null || userDTO.getPhoneNumber().length() > 11) {
            throw new CustomException("Телефон не должен содержать более 11 цифр", HttpStatus.CONFLICT);}
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPersonalAccount(userDTO.getPersonalAccount());
        user.setRoomArea(userDTO.getRoomArea());
        user.setUserAddress(userDTO.getUserAddress());
        user.setActive(true);
        user.setTasks(user.getTasks());
        Set<Role> roles = user.getRoles();
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        log.info("Сохранение нового пользователя: {}", email);
        userRepository.save(user);
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new CustomException("Такого пользователя не существует!"
                        , HttpStatus.NOT_FOUND));
    }

//    public User getUserByPrincipal(Principal principal) {
//        if (principal == null) return new User();
//        return userRepository.findByEmail(principal.getName()).get();
//    }

    public void changeUserRoles(User user, Role role) {
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @PostConstruct
    public void runAfterObjectCreated() {
        User user = new User();
        user.setEmail("admin@admin");
        user.setName("admin");
        user.setPhoneNumber("911");
        user.setUserAddress("Office");
        user.setPersonalAccount("000");
        user.setRoomArea(500.0);
        user.setPassword(passwordEncoder.encode("1"));;
        user.setId(1L);
        user.setActive(true);
        Set<Role> roles = user.getRoles();
        roles.add(Role.ROLE_ADMIN);
        user.setRoles(roles);
        userRepository.save(user);
    }
}