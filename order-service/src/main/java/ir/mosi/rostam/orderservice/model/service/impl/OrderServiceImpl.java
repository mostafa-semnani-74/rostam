package ir.mosi.rostam.orderservice.model.service.impl;

import ir.mosi.rostam.orderservice.model.entity.Order;
import ir.mosi.rostam.orderservice.model.entity.Product;
import ir.mosi.rostam.orderservice.model.repository.OrderRepository;
import ir.mosi.rostam.orderservice.model.repository.ProductRepository;
import ir.mosi.rostam.orderservice.model.service.OrderService;
import ir.mosi.rostam.orderservice.model.vo.OrderResponse;
import ir.mosi.rostam.orderservice.model.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final WebClient.Builder webClientBuilder;

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

    @Override
    public OrderResponse findById(Long id) {
        Optional<Order> orderOpt = orderRepository.findById(id);

        if (orderOpt.isPresent()) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setOrder(orderOpt.get());

            String productIds = orderOpt.get().getProducts()
                    .stream()
                    .map(Product::getProductId)
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            ProductVO[] productVOs = webClientBuilder.build().get()
                    .uri("http://product-service/api/v1/products/findByIds/" + productIds)
                    .retrieve()
                    .bodyToMono(ProductVO[].class)
                    .block();

            if (productVOs != null)
                orderResponse.setProductVO(Arrays.asList(productVOs));

            return orderResponse;
        } else
            throw new RuntimeException("order not found with id : " + id);
    }

}
