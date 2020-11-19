package com.example.builddream.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface RbacService {
    public boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
