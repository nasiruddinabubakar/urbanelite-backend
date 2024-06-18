package com.example.urbanelite.repository;

import com.example.urbanelite.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN FETCH o.orderItems oi JOIN FETCH oi.product WHERE o.user.id = :userId")
    List<Order> findOrdersByUserId(@Param("userId") Long userId);
}
