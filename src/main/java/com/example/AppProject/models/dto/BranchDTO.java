package com.example.AppProject.models.dto;

import com.example.AppProject.models.enums.BranchName;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BranchDTO {

    String address;
    String phone;
    BranchName branchName;
}
