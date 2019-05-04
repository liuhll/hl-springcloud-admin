package com.liuhll.hl.product.domain.entity;

import com.liuhll.hl.common.core.domain.auditing.AuditedEntity;
import com.liuhll.hl.product.domain.models.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_category")
public class ProductCategory extends AuditedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "parent_id",nullable = false)
    private Long parentId;

    @Basic
    @Column(name = "name",nullable = false)
    private String name;

    @Basic
    @Column(name = "status",nullable = false)
    private Integer status = CommonStatus.Valid.getStatus();

    public ProductCategory(Long parentId,String name,CommonStatus status){
        this.parentId = parentId;
        this.name = name;
        this.status = status.getStatus();
    }

    public ProductCategory(Long parentId,String name){
        this.parentId = parentId;
        this.name = name;
        this.status = CommonStatus.Valid.getStatus();
    }
}
