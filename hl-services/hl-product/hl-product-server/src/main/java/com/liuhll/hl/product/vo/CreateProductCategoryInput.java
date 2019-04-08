package com.liuhll.hl.product.vo;

import lombok.Data;

@Data
public class CreateProductCategoryInput {

    private Long parentId;

    private String name;

}
