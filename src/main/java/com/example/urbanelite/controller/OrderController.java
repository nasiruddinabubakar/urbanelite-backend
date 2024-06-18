package com.example.urbanelite.controller;

import com.example.urbanelite.model.OrderModel;
import com.example.urbanelite.service.OrderService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public String createOrder(
            @NotNull
            @RequestBody OrderModel orderModel,
            @RequestParam Long userId)
    {

        orderService.addNewOrder(userId, Objects.requireNonNull(orderModel));
        return "Order placed Successfully";
    }
}
