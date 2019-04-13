package com.liuhll.hl.product.controller;

import com.liuhll.hl.product.domain.service.ProductCategoryService;
import com.liuhll.hl.product.vo.CreateProductCategoryInput;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api("ProductCategoryController")
@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping("/category")
    public String addProductCategory(@RequestBody CreateProductCategoryInput input){
        productCategoryService.addProductCategory(input);
        return "新增产品类别成功";
    }


}
