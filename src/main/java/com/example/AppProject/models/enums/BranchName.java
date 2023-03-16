package com.example.AppProject.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BranchName {

    RYBATSKOE("филиал Рыбацкое"),
    MURINO("филиал Мурино"),
    KOLPINO("филиал Колпино"),
    PESOCHNY("филиал Песочный"),
    LIGOVSKY("филиал Лиговский");

    private final String description;


    public void add(BranchName[] values) {
    }
}
