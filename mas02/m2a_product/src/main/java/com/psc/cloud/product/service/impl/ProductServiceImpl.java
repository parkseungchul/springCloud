package com.psc.cloud.product.service.impl;

import com.psc.cloud.product.domain.Product;
import com.psc.cloud.product.repository.ProductRepository;
import com.psc.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> list(Product product) {
        return null;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
