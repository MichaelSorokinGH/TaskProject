package com.example.AppProject.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobTitle {

    CEO("Генеральный директор"),
    HEAD_ENGINEER("Главный инженер"),
    DEPARTMENT_HEAD("Начальник отдела"),
    BRANCH_MANAGER("Начальник филиала"),
    MASTER("Мастер"),
    ENGINEER("Инженер"),
    ACCOUNTANT("Бухгалтер"),
    TECHNICIAN("Дежурный техник"),
    ELECTRICIAN("Электрик"),
    PLUMBER("Сантехник"),
    OPERATOR("Диспетчер");

    private final String description;
}
