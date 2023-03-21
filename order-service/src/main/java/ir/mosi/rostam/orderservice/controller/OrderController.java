package ir.mosi.rostam.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import ir.mosi.rostam.orderservice.config.RabbitMQConfig;
import ir.mosi.rostam.orderservice.messaging.message.CustomMessage;
import ir.mosi.rostam.orderservice.model.entity.Order;
import ir.mosi.rostam.orderservice.model.service.OrderService;
import ir.mosi.rostam.orderservice.model.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final RabbitTemplate rabbitTemplate;
    private final OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/findById/{id}")
    @CircuitBreaker(name = "productService", fallbackMethod = "productServiceFallBack")
    @Retry(name = "productService")
    //@RateLimiter(name = "productService", fallbackMethod = "productServiceRateLimiterFallBack")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @PostMapping("/publishMessage")
    public String publishMessage(@RequestBody CustomMessage customMessage) {
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(RabbitMQConfig.MESSAGE_EXCHANGE, RabbitMQConfig.ROUTING_KEY, customMessage);
        return "Message sent";
    }

    public ResponseEntity<String> productServiceFallBack(Long id, Exception e) {
        return ResponseEntity.internalServerError().body("product service is not available, please try later");
    }

//    public ResponseEntity<String> productServiceRateLimiterFallBack(Long id, Exception e) {
//        return ResponseEntity.badRequest().body("dont send many requests");
//    }

}
