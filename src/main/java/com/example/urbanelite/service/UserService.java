package com.example.urbanelite.service;

import com.example.urbanelite.entity.User;
import com.example.urbanelite.model.UserModel;
import com.example.urbanelite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveNewUser(UserModel userModel){

        System.out.println(userModel);

        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());

        userRepository.save(user);


        return user;
    }

}
