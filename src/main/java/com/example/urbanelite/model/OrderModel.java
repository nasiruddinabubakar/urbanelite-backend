package com.example.urbanelite.model;

import com.example.urbanelite.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderModel {
    private List<OrderItemRequest> orderItems;

}
