package com.example.AppProject.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DepartmentName {

    CONSTRUCTION_DEPARTMENT("Отдел строительства и кап. ремонта"),
    IMPROVEMENT_DEPARTMENT("Отдел программ и благоустройства"),
    WATER_DEPARTMENT("Отдел тепло-, водоснабжения и водоотведения"),
    OVERHAUL_DEPARTMENT("Отдел капитального ремонта МКД"),
    DEPARTMENT_OF_ELECTRIC_AND_GAS_SUPPLY(" Отдел электро-, газоснабжения"),
    DEPARTMENT_OF_DOCUMENTATION_SUPPORT("Отдел документационного и информационного сопровождения"),
    LEGAL_DEPARTMENT("Отдел правового обеспечения"),
    FINANCE_DEPARTMENT(" Отдел финансирования и бухгалтерского учёта");

    private final String description;



}
