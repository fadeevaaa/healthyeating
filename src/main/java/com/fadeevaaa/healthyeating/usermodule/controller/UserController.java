package com.fadeevaaa.healthyeating.usermodule.controller;

import com.fadeevaaa.healthyeating.usermodule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        
    }
}
