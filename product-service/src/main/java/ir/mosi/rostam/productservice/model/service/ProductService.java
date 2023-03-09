package ir.mosi.rostam.productservice.model.service;

import ir.mosi.rostam.productservice.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);

    Optional<Product> findById(Long id);

    List<Product> findByIdIn(List<Long> ids);
}
