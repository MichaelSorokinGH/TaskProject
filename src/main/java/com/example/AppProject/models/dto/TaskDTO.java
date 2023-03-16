package com.example.AppProject.models.dto;

import com.example.AppProject.models.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDTO {

    String title;
    String description;
    String price;
    String address;
    Status status;
}
