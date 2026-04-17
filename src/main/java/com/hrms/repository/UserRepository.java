package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.hrms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}