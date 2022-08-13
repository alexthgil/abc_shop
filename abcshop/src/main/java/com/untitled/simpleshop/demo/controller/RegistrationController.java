package com.untitled.simpleshop.demo.controller;

import com.untitled.simpleshop.demo.domain.Role;
import com.untitled.simpleshop.demo.domain.User;
import com.untitled.simpleshop.demo.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class RegistrationController {

        @Autowired
        private UserRepository userRepository;

        @GetMapping("/registration")
        public String registration() {
            return "registration";
        }

        @PostMapping("/registration")
        public String addUser(User user, Map<String, Object> model) {
            user.setActive(true);
            Set<Role> rolesSet = new HashSet<Role>();
            rolesSet.add(Role.USER);
            user.setRoles(rolesSet);
            userRepository.save(user);
            return "redirect:/login";
        }
}
