package ir.mosi.rostam.orderservice.model.service.impl;

import ir.mosi.rostam.orderservice.model.entity.Order;
import ir.mosi.rostam.orderservice.model.repository.OrderRepository;
import ir.mosi.rostam.orderservice.model.repository.ProductRepository;
import ir.mosi.rostam.orderservice.model.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public Order save(Order order) {
        productRepository.saveAll(order.getProducts());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
