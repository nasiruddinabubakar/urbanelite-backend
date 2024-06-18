package com.example.urbanelite.controller;

import com.example.urbanelite.entity.User;
import com.example.urbanelite.model.UserModel;
import com.example.urbanelite.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/")
    public String createUser(@Validated @RequestBody UserModel userModel) {

        userService.saveNewUser(userModel);
        return "User Created";
    }

    @GetMapping(path = "/")
    public Optional<User> getUser(@Validated @RequestParam Long userId) {

        return userService.getUserById(userId);

    }

    @PutMapping(path = "/")
    public String updateUser(
            @Validated
            @RequestBody UserModel updatedUser,
            @RequestParam Long userId)
    {
        userService.updateUserById(userId,updatedUser);
        return "User updated !";
    }


}
