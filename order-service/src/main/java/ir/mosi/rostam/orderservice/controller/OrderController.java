package ir.mosi.rostam.orderservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import ir.mosi.rostam.orderservice.model.entity.Order;
import ir.mosi.rostam.orderservice.model.service.OrderService;
import ir.mosi.rostam.orderservice.model.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
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

    public ResponseEntity<String> productServiceFallBack(Long id, Exception e) {
        return ResponseEntity.internalServerError().body("product service is not available, please try later");
    }

//    public ResponseEntity<String> productServiceRateLimiterFallBack(Long id, Exception e) {
//        return ResponseEntity.badRequest().body("dont send many requests");
//    }

}
