package com.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hrms.repository.UserRepository;
import com.hrms.security.JwtUtil;
import com.hrms.dto.*;
import com.hrms.entity.User;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public UserDTO register(AuthRequest req) {

        User user = User.builder()
                .username(req.getUsername())
                .password(encoder.encode(req.getPassword()))
                .role("EMPLOYEE")
                .build();

        repo.save(user);

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    public AuthResponse login(AuthRequest req) {

        User user = repo.findByUsername(req.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token);
    }
}