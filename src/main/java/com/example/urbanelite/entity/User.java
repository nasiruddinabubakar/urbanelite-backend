package com.example.urbanelite.entity;

import jakarta.persistence.*;
import lombok.*;


@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    @Column(unique = true)
    private String email;
    @Setter
    private String password;

}
