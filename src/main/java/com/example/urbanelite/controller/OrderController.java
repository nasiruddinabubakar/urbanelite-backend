package com.example.urbanelite.controller;

import com.example.urbanelite.entity.Order;
import com.example.urbanelite.entity.User;
import com.example.urbanelite.model.OrderItemRequest;
import com.example.urbanelite.model.OrderModel;
import com.example.urbanelite.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<String> createOrder(
            @NotNull @RequestBody List<OrderItemRequest> orderItemRequestList
           ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User)  authentication.getPrincipal();
        // Assuming orderModel is already populated correctly from the request body
        orderService.addNewOrder(currentUser.getUserId(), Objects.requireNonNull(orderItemRequestList));

        return ResponseEntity.ok("Order placed successfully");
    }

    @GetMapping("/")
    public List<Order> getUserOrders(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User)  authentication.getPrincipal();
        System.out.println(currentUser.getUserId());
        return orderService.getOrdersByUserId(currentUser.getUserId());

    }
}
