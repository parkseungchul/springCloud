package com.psc.cloud.product.init;

import com.psc.cloud.product.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class InitData {

    public List<Product> productList(){

        List<Product> productList = new ArrayList<Product>();

        productList.add(new Product());


        return productList;
    }
}
