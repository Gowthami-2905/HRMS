package com.hrms.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.hrms.service.AuthService;
import com.hrms.dto.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public UserDTO register(@RequestBody AuthRequest req) {
        return service.register(req);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {
        return service.login(req);
    }
}