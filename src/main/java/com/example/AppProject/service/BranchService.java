package com.example.AppProject.service;

import com.example.AppProject.models.dto.BranchDTO;
import com.example.AppProject.models.entity.Branch;
import com.example.AppProject.models.entity.Task;

import java.util.List;

public interface BranchService {

    void createBranch(BranchDTO branchDTO);

    Branch getBranch(String address);

//    List<Task> tasks(String title);

    List<Branch> findAllBranches();


}
