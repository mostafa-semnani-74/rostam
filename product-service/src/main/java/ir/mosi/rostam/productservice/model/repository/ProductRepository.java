package ir.mosi.rostam.productservice.model.repository;

import ir.mosi.rostam.productservice.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByIdIn(List<Long> ids);

}
