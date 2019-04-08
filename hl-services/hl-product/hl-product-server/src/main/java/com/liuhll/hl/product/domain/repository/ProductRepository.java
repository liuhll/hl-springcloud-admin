package com.liuhll.hl.product.domain.repository;

import com.liuhll.hl.product.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Product saveAndFlush(Product product);
}
