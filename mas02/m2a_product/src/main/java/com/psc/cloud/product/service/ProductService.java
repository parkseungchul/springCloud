package com.psc.cloud.product.service;

import com.psc.cloud.product.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> list(Product product);

    void add(Product product);

    void update(Product product);

    void delete(Product product);
}
