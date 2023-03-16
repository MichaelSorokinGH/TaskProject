package com.example.AppProject.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusOfApplicaton {

    UNDER_CONSIDERATION("На рассмотрении"),
    IN_WORK("В работе"),
    POSTPONED("Отложена"),
    COMPLETED("Выполнена"),
    REJECTED("Отклонена");

    private final String description;
}
