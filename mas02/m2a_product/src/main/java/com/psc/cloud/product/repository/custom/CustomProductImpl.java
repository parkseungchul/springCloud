package com.psc.cloud.product.repository.custom;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.domain.Product;
import com.psc.cloud.product.domain.QCode;
import com.psc.cloud.product.domain.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class CustomProductImpl extends QuerydslRepositorySupport implements CustomProduct {
    public CustomProductImpl() {
        super(Product.class);
    }

    public List<Product> listProduct(Product product){

        QProduct qProduct = QProduct.product;
        QCode qCode = QCode.code;
        JPQLQuery<Product> query = from(qProduct);
        JPQLQuery<Tuple> tuple = query.select(
                qProduct.productId,
                qProduct.productName,
                qProduct.enabled,
                qProduct.description,
                qCode.codeId,
                qCode.parentId,
                qCode.codeName,
                qCode.enabled,
                qCode.description
        );

        tuple.leftJoin(qCode);
        tuple.on(qProduct.code.codeId.eq(qCode.codeId));
        tuple.where(qProduct.code.codeId.eq(qCode.codeId));

        if(product != null){
            if(product.getCode() != null){
                Code code = product.getCode();
                Long codeId = code.getCodeId();
                tuple.where(qCode.codeId.eq(codeId));
            }
            if(product.getProductId() != null){
                tuple.where(qProduct.productId.eq(product.getProductId()));
            }
            if(product.getProductName() != null){
                tuple.where(qProduct.productName.like("%"+product.getProductName()+"%"));
            }
            if(product.getEnabled() != null){
                tuple.where(qProduct.enabled.eq(product.getEnabled()));
            }
            if(product.getDescription() != null){
                tuple.where(qProduct.description.like("%"+product.getDescription()+"%"));
            }
        }

        List<Tuple> list = tuple.fetch();
        List<Product> resultList = new ArrayList<>();
        list.forEach(t -> {
            Object[] object = t.toArray();
            Product product1 = new Product();
            product1.setProductId((Long)object[0]);
            product1.setProductName((String)object[1]);
            product1.setEnabled((Boolean)object[2]);
            product1.setDescription((String)object[3]);
            product1.setCode(new Code((Long)object[4], (Long)object[5], (String)object[6], (Boolean)object[7], (String)object[8]));
            resultList.add(product1);
        });
        return resultList;
    }
}
