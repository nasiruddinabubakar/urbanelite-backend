package com.example.urbanelite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "order_id",

            nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",

            nullable = false)
    private Product product;

    private int quantity;


}
