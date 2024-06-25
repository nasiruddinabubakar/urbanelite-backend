package com.example.urbanelite.repository;


import com.example.urbanelite.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Table;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {
        // Assume that a user with this email exists in the database
        String email = "ali@gmail.com";

        // Fetch the user and verify the instance
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("No user exists with email: " + email));

        // Check that the user is not null
        assertThat(user).isNotNull();

        // Check that the user is an instance of User class
        assertThat(user).isInstanceOf(User.class);

        // Verify the email
        assertThat(user.getEmail()).isEqualTo(email);

        // Verify other properties as needed (e.g., firstName, lastName, etc.)
        assertThat(user.getFirstName()).isEqualTo("Ali");
        assertThat(user.getLastName()).isEqualTo("Hambal");
        // Add more assertions as necessary based on your User entity

        // Ensure correct exception handling
        String nonExistentEmail = "nonexistent@example.com";
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> {
            userRepository.findByEmail(nonExistentEmail).orElseThrow(() -> new EntityNotFoundException("No user exists with email: " + nonExistentEmail));
        });

        assertThat(exception.getMessage()).isEqualTo("No user exists with email: " + nonExistentEmail);
    }
}
