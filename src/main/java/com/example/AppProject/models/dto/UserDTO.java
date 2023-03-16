package com.example.AppProject.models.dto;

import com.example.AppProject.models.entity.Task;
import com.example.AppProject.models.enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    String name;
    String surname;
    String email;
    String phoneNumber;
    String personalAccount;
    Double roomArea;
    String userAddress;
    boolean active;
    String password;

    Role role;

    List<Task> tasks;
}
