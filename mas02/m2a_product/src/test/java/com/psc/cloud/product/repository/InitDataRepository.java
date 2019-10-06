package com.psc.cloud.product.repository;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.init.InitData;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Commit
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InitDataRepository {

    @Autowired
    CodeRepository codeRepository;

    @Autowired
    InitData initData;

    @Test
    public void a1_codeInsert(){
        initData.codeDeleteAll();
        initData.productDeleteAll();

        initData.codeSaveLv1();
        initData.codeSaveLv2();
        initData.productSaveLv1();
    }

}
