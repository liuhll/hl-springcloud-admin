package com.liuhll.hl.product.domain.entity;

import com.liuhll.hl.common.domain.auditing.AuditedEntity;
import com.liuhll.hl.product.domain.models.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product  extends AuditedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "category_id",nullable = false)
    private Long categoryId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "status",nullable = false)
    private Integer status = CommonStatus.Valid.getStatus();

    @Basic
    @Column(name = "sub_title",nullable = false)
    private String subTitle;

    @Basic
    @Column(name = "main_image",nullable = false)
    private String mainImage;

    @Basic
    @Column(name = "sub_images",nullable = false)
    private String subImages;

    @Basic
    @Column(name = "detail",nullable = false)
    private String detail;

    @Basic
    @Column(name = "origin_price",nullable = false)
    private BigDecimal originPrice;

    @Basic
    @Column(name = "sales_price",nullable = false)
    private BigDecimal salesPrice;

    @Basic
    @Column(name = "stock",nullable = false)
    private Integer stock = 0;

    public Product(Long categoryId,String name,CommonStatus status,String subTitle,String mainImage,String subImages,String detail,BigDecimal originPrice,BigDecimal salesPrice){
        this.categoryId = categoryId;
        this.name = name;
        this.status = status.getStatus();
        this.subTitle = subTitle;
        this.mainImage = mainImage;
        this.subImages = subImages;
        this.detail = detail;
        this.originPrice = originPrice;
        this.salesPrice = salesPrice;
    }
}
