package com.example.urbanelite.controller;

import com.example.urbanelite.model.UserModel;
import com.example.urbanelite.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public String createUser(@Validated @RequestBody UserModel userModel ){

         userService.saveNewUser(userModel);
        return "User Created";
    }


}
