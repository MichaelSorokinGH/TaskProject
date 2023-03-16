package com.example.AppProject.service.impl;

import com.example.AppProject.exceptions.CustomException;
import com.example.AppProject.models.dto.BranchDTO;
//import com.example.AppProject.models.entity.Branch;
import com.example.AppProject.models.entity.Branch;
import com.example.AppProject.models.repositories.BranchRepository;
import com.example.AppProject.models.repositories.UserRepository;
import com.example.AppProject.service.BranchService;
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
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    private final UserRepository userRepository;

    private final ObjectMapper mapper;

    @Override
    public void createBranch(BranchDTO branchDTO) {
        branchRepository.findByAddress(branchDTO.getAddress()).ifPresent(
                s -> {
                    throw new CustomException("Филиал по данному адресу " + branchDTO.getAddress() + " уже существует!", HttpStatus.CONFLICT);
                });
        branchRepository.findByPhone(branchDTO.getPhone()).ifPresent(
                s -> {
                    throw new CustomException("Филиал с указанным номером " + branchDTO.getPhone() + " уже существует!", HttpStatus.CONFLICT);
                });
        if (branchDTO.getAddress() == null || branchDTO.getAddress() == null) {
            throw new CustomException("Необходимо ввести адрес", HttpStatus.CONFLICT);
        }

        Branch branch = mapper.convertValue(branchDTO, Branch.class);
        branch.setCreatedAt(LocalDateTime.now());
        branchRepository.save(branch);
    }
    @Override
    public Branch getBranch(String address) {
        return branchRepository.findByAddress(address).get();
    }
//    @Override
//    public List<Task> tasks(String title) {
//        Branch branch = branchRepository
//                .findByAddress(userRepository.findByEmail(email).get().getAddress).get();
//        return branch.getTasks();
//    }
    @Override
    public List<Branch> findAllBranches() {
        return branchRepository.findAll();
    }
}


