package com.liuhll.hl.product.domain.service.impl;

import com.liuhll.hl.product.domain.entity.ProductCategory;
import com.liuhll.hl.product.domain.repository.ProductCategoryRepository;
import com.liuhll.hl.product.domain.service.ProductCategoryService;
import com.liuhll.hl.product.vo.CreateProductCategoryInput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public void addProductCategory(CreateProductCategoryInput input) {

        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(input,productCategory);
        productCategoryRepository.save(productCategory);
    }
}
