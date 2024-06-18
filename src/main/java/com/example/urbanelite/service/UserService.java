package com.example.urbanelite.service;

import com.example.urbanelite.entity.User;
import com.example.urbanelite.model.UserModel;
import com.example.urbanelite.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void saveNewUser(UserModel userModel){

        System.out.println(userModel);

        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());

        userRepository.save(user);


    }

    public Optional<User> getUserById(Long userId) {

        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) throw new IllegalStateException("No User exists by this id");
        return user;
    }

    @Transactional
    public void updateUserById(Long userId, @NotNull UserModel updatedUser) {
       User user = userRepository.findById(userId).orElseThrow(()->new IllegalStateException("No User found with id "+ userId));


        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());

    }
}
