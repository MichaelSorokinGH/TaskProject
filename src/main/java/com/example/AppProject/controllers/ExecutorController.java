package com.example.AppProject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ROLE_EXECUTOR')")

public class ExecutorController {
}
