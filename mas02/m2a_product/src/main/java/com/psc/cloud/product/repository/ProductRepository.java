package com.psc.cloud.product.repository;

import com.psc.cloud.product.domain.Product;
import com.psc.cloud.product.repository.custom.CustomProduct;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>, CustomProduct {

    Product findByProductName(String ProductName);
}
