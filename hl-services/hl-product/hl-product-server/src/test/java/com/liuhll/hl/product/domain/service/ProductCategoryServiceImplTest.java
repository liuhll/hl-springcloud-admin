package com.liuhll.hl.product.domain.service;

import com.liuhll.hl.ProductApplicationTests;
import com.liuhll.hl.product.domain.service.impl.ProductCategoryServiceImpl;
import com.liuhll.hl.product.vo.CreateProductCategoryInput;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void addProductCategory()  throws Exception{
        CreateProductCategoryInput productCategoryInput = new CreateProductCategoryInput();
        productCategoryInput.setName("电脑");
        productCategoryInput.setParentId(Long.valueOf(0));
        productCategoryService.addProductCategory(productCategoryInput);
    }
}
