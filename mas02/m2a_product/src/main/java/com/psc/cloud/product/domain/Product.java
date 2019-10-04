package com.psc.cloud.product.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;

    @Column(name="code_id")
    private Long codeId;

    @Column(name="product_name")
    private String productName;

    private String enable;
    private String description;



}



