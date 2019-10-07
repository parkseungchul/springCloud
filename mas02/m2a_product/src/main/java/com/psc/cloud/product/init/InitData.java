package com.psc.cloud.product.init;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.domain.Product;
import com.psc.cloud.product.repository.CodeRepository;
import com.psc.cloud.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData {

    @Autowired
    CodeRepository codeRepository;

    @Autowired
    ProductRepository productRepository;

    @Transactional
    public void codeDeleteAll(){
        codeRepository.deleteAll();
    }

    @Transactional
    public void productDeleteAll(){
        productRepository.deleteAll();
    }

    @Transactional
    public void deleteAll(){
        productDeleteAll();
        codeDeleteAll();
    }

    @Transactional
    public void saveAll(){
        codeSaveLv1();
        codeSaveLv2();
        productSaveLv1();
    }

    public List<Code> codeDataLv1(){
        List<Code> list = new ArrayList<Code>();
        list.add(new Code(0L, "drink", true,"마실 것"));
        list.add(new Code(0L, "desert", true,"먹을 것"));
        return list;
    }

    @Transactional
    public void codeSaveLv1(){
        codeRepository.saveAll(codeDataLv1());
    }

    public List<Code> codeDataLv2(){
        List<Code> list = new ArrayList<Code>();

        Code code = codeRepository.findByCodeName("drink");
        list.add(new Code(code.getCodeId(), "coffee", true, "커피"));
        list.add(new Code(code.getCodeId(), "carbonic", true, "탄산"));

        code = codeRepository.findByCodeName("desert");
        list.add(new Code(code.getCodeId(), "cake", true, "케이크"));
        return list;
    }

    @Transactional
    public void codeSaveLv2(){
        codeRepository.saveAll(codeDataLv2());
    }

    public List<Product> productDataLv1(){
        List<Product> list = new ArrayList<Product>();

        Code code = codeRepository.findByCodeName("coffee");
        list.add(new Product(code.getCodeId(),"americano", true, "아메리카노"));
        list.add(new Product(code.getCodeId(),"latte", true, "라떼"));

        code = codeRepository.findByCodeName("carbonic");
        list.add(new Product(code.getCodeId(),"coke", true, "코크"));
        list.add(new Product(code.getCodeId(),"fanta", true, "환타"));

        code = codeRepository.findByCodeName("cake");
        list.add(new Product(code.getCodeId(),"chocolate", true, "초코 케익"));
        list.add(new Product(code.getCodeId(),"strawberry", true, "딸기 케익"));
        return list;
    }

    public void productSaveLv1(){
        productRepository.saveAll(productDataLv1());
    }

}
