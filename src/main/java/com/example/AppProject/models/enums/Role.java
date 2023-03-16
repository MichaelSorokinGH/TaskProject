package com.example.AppProject.models.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_USER,
    ROLE_ADMIN,
    ROLE_EXECUTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
