package ir.mosi.rostam.orderservice.model.service;

import ir.mosi.rostam.orderservice.model.entity.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    List<Order> findAll();
}
