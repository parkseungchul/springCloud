package com.psc.cloud.product.service;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckService {

    @Autowired
    CodeService codeService;

    @Autowired
    ProductService productService;

    @Test
    public void codeList(){
        codeService.list(null).forEach(code -> {
           log.debug(code.toString());
        });
    }

    @Test
    public void productList(){
        productService.list(null).forEach(product -> {
            log.debug(product.toString());
        });
    }

    @Test
    public void productSearch(){
        Product product = new Product();
        product.setDescription("케");
        product.setProductName("cho");
        productService.list(product).forEach(product2 -> {
            log.debug(product2.toString());
        });
    }

    @Test
    public void codeSearch(){
        Code code = new Code();
        code.setParentId(0L);
        codeService.list(code).forEach(code2 -> {
            log.debug(code2.toString());
        });

    }


}
