//package com.example.AppProject.controllers;
//
//import com.example.AppProject.models.dto.BranchDTO;
//import com.example.AppProject.service.impl.BranchService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/branches")
//public class BranchController {
//
//    private final BranchService branchService;
//
//    @PostMapping("/create_branch")
//    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) {
//        return ResponseEntity.ok(branchService.createBranch(branchDTO));
//    }
//
//    @GetMapping
//    public ResponseEntity<BranchDTO> getBranch(@RequestParam Long id) {
//        return ResponseEntity.ok(branchService.get(id));
//    }
//}
