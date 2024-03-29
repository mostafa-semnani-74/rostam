package ir.mosi.rostam.productservice.controller;

import ir.mosi.rostam.productservice.model.entity.Product;
import ir.mosi.rostam.productservice.model.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> productOpt = productService.findById(id);
        if (productOpt.isPresent())
            return ResponseEntity.ok(productOpt.get());
        else
            throw new RuntimeException("product not found with id : " + id);
    }

    @GetMapping("/findByIds/{ids}")
    public ResponseEntity<List<Product>> findByIds(@PathVariable String ids) {
        return ResponseEntity.ok(productService.findByIdIn(
                Arrays.stream(ids.split(","))
                        .map(Long::parseLong)
                        .collect(Collectors.toList())));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

}
