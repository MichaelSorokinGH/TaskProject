package com.example.AppProject.models.dto;

import com.example.AppProject.models.enums.DepartmentName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {

    String address;
    String phone;
    DepartmentName departmentName;

}
