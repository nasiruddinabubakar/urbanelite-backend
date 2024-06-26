package com.example.urbanelite.model;


import lombok.Getter;
import lombok.Setter;

@Getter
public class UserModel {

    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String email;
    @Setter
    private String password;

}
