package com.example.urbanelite.service;

import com.example.urbanelite.entity.Order;
import com.example.urbanelite.entity.OrderItem;
import com.example.urbanelite.entity.Product;
import com.example.urbanelite.entity.User;
import com.example.urbanelite.model.OrderItemRequest;
import com.example.urbanelite.repository.OrderRepository;
import com.example.urbanelite.repository.ProductRepository;
import com.example.urbanelite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        ProductRepository productRepository) {

        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void addNewOrder(Long userId, List<OrderItemRequest> orderItemRequestList) {

        Order order = new Order();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("No user found with id " + userId));

        order.setUser(user);

        List<OrderItem> orderItemList = orderItemRequestList.stream().map((itemRequest) -> {
            OrderItem orderItem = new OrderItem();
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("No Product found"));

            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setOrder(order);
            return orderItem;
        }).toList();

        order.setOrderItems(orderItemList);

        orderRepository.save(order);


    }

    public List<Order> getOrdersByUserId(Long userId) {

        return orderRepository.findOrdersByUserId(userId);

    }
}
