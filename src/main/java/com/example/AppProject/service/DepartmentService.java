package com.example.AppProject.service;

import com.example.AppProject.models.dto.DepartmentDTO;
import com.example.AppProject.models.entity.Department;
import com.example.AppProject.models.entity.Task;

import java.util.List;

public interface DepartmentService {

    void createDepartment(DepartmentDTO departmentDTO);

    List<Department> findAllDepartment();

    List<Task> tasks(String title);

}
