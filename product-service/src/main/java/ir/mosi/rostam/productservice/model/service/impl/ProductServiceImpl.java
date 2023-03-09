package ir.mosi.rostam.productservice.model.service.impl;

import ir.mosi.rostam.productservice.model.entity.Product;
import ir.mosi.rostam.productservice.model.repository.ProductRepository;
import ir.mosi.rostam.productservice.model.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByIdIn(List<Long> ids) {
        return productRepository.findByIdIn(ids);
    }
}
