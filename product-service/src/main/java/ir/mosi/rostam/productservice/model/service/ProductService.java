package ir.mosi.rostam.productservice.model.service;

import ir.mosi.rostam.productservice.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product save(Product product);
}
