package com.hrms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String role; // ADMIN / EMPLOYEE
}