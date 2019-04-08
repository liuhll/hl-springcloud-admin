package com.liuhll.hl.product.domain.repository;

import com.liuhll.hl.product.domain.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
