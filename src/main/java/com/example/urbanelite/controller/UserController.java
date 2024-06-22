package com.example.urbanelite.controller;

import com.example.urbanelite.entity.User;
import com.example.urbanelite.model.UserModel;
import com.example.urbanelite.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/getuser")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();
        System.out.println(currentUser);

        return ResponseEntity.ok(currentUser);
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
