package com.untitled.simpleshop.demo.repos;

import com.untitled.simpleshop.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
