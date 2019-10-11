package com.psc.cloud.product.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_product")
@ToString
public class Product {

    public Product(){

    }

    public Product(long codeId, String productName, boolean enabled, String description){
        Code code = new Code();
        code.setCodeId(codeId);

        this.code = code;
        this.productName = productName;
        this.enabled = enabled;
        this.description = description;
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

    private Boolean enabled;
    private String description;
}



