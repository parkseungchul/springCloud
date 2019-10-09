package com.psc.cloud.product.repository.custom;

import com.psc.cloud.product.domain.Product;

import java.util.List;

public interface CustomProduct {

    public List<Product> listProduct(Product product);
}
