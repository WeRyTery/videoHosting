package org.learningproject.Users.controllers;

import org.learningproject.Users.model.User;
import org.learningproject.Users.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUser {
    private final UserService userService;
    public LoginUser(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/videoHosting/login")
    public ResponseEntity login(@RequestBody User user) {
        String loginStatus = userService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(loginStatus);
    }

}
