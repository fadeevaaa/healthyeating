package com.fadeevaaa.healthyeating.usermodule.controller;

import com.fadeevaaa.healthyeating.usermodule.model.entity.User;
import com.fadeevaaa.healthyeating.usermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        userService.create(user);
    }
}
