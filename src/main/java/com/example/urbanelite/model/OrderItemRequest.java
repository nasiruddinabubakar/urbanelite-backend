package com.example.urbanelite.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemRequest {

        @Setter
        private Long productId;
        @Setter
        private int quantity;

        // Getters and setters


}
