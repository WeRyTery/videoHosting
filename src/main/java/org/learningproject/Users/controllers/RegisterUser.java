package org.learningproject.Users.controllers;

import org.learningproject.Users.model.User;
import org.learningproject.Users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterUser {
    private final UserService userService;

    public RegisterUser(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/videoHosting/register")
    public ResponseEntity Register(@RequestBody() User user) {
        userService.save(user.getUsername(), user.getEmail(), user.getPassword());
        return ResponseEntity.ok("Registration successful!");
    }
}
