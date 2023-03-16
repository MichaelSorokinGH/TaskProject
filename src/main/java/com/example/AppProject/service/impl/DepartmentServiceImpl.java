package com.example.AppProject.service.impl;

import com.example.AppProject.exceptions.CustomException;
import com.example.AppProject.models.dto.DepartmentDTO;
import com.example.AppProject.models.entity.Branch;
import com.example.AppProject.models.entity.Department;
import com.example.AppProject.models.entity.Task;
import com.example.AppProject.models.repositories.BranchRepository;
import com.example.AppProject.models.repositories.DepartmentRepository;
import com.example.AppProject.models.repositories.UserRepository;
import com.example.AppProject.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ObjectMapper mapper;

    private final UserRepository userRepository;

    private final BranchRepository branchRepository;
    /**
     * @param departmentDTO
     * @return
     */
    @Override
    public void createDepartment(DepartmentDTO departmentDTO) {
        if (departmentDTO.getPhone() == null) {
            throw new CustomException("Введите телефон", HttpStatus.CONFLICT);
        }
        Department department = mapper.convertValue(departmentDTO, Department.class);
        Branch branch = branchRepository.findByAddress(departmentDTO.getAddress()).orElseThrow(
                () -> new CustomException("Филиал по данному адресу не найден", HttpStatus.NOT_FOUND)
        );
        departmentRepository.findByAddress(departmentDTO.getAddress()).ifPresent(h -> {
            throw new CustomException("Отдел по такому адресу уже существует", HttpStatus.CONFLICT);
        });
        departmentRepository.findByPhone(departmentDTO.getPhone()).ifPresent(
                s -> {
                    throw new CustomException("Отдел c таким номером телефона " + departmentDTO.getPhone() + " уже существует", HttpStatus.CONFLICT);
                });
        department.setCreatedAt(LocalDateTime.now());
        departmentRepository.save(department);

    }

    /**
     * @return
     */
    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    /**
     * @param title
     * @return
     */
    @Override
    public List<Task> tasks(String title) {
        return null;
    }

}
