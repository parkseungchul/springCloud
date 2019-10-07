package com.psc.cloud.product.service;

import com.psc.cloud.product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> list(Product product);

    void add(Product product);

    void update(Product product);

    void delete(Product product);
}
