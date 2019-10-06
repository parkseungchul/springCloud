package com.psc.cloud.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_product")
@AllArgsConstructor
public class Product {

    public Product(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long productId;

    @ManyToOne(targetEntity = Code.class, fetch=FetchType.LAZY)
    @JoinColumn(name = "codeId")
    @JsonIgnore
    private Code code;

    @Column(name="product_name")
    private String productName;

    private boolean enabled;
    private String description;
}



