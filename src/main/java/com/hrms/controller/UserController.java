package com.hrms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('ADMIN','EMPLOYEE')")
    public String profile() {
        return "User Profile";
    }
}