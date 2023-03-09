package ir.mosi.rostam.orderservice.model.repository;

import ir.mosi.rostam.orderservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
