package com.psc.cloud.product.repository.custom;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.domain.QCode;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CustomCodeImpl extends QuerydslRepositorySupport implements CustomCode {
    public CustomCodeImpl() {
        super(Code.class);
    }

    public List<Code> listCode(Code code){
        QCode qCode = QCode.code;
        JPQLQuery<Code> query = from(qCode);
        JPQLQuery<Code> jpqlQuery = query.select(qCode);
        return jpqlQuery.fetch();
    }
}
