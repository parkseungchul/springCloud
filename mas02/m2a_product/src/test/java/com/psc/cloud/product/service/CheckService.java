package com.psc.cloud.product.service;

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

}
