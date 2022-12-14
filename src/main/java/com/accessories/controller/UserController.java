package com.accessories.controller;

import com.accessories.model.Users;
import com.accessories.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public String createUser(@RequestBody Users users) {
        return userService.createUser(users);
    }

    @PostMapping("login")
    public String loginUser(@RequestBody Users users) {
        return userService.verifyUser(users);
    }

}
