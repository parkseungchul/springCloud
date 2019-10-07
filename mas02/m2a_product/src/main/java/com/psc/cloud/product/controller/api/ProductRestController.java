package com.psc.cloud.product.controller.api;

import com.psc.cloud.product.domain.Product;
import com.psc.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/list" ,method = {RequestMethod.GET})
    public List<Product> list(Product product){
        return productService.list(product);
    }

    @RequestMapping(value="/add" ,method = {RequestMethod.POST})
    public void add(Product product){
        productService.add(product);
    }

    @RequestMapping(value="/update" ,method = {RequestMethod.POST})
    public void update(Product product){
        productService.update(product);
    }

    @RequestMapping(value="/delete" ,method = {RequestMethod.POST})
    public void delete(Product product){
        productService.delete(product);
    }
}
