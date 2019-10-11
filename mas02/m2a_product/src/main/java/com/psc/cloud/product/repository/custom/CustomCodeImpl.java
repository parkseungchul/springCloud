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

        if(code != null){
            if(code.getCodeId() != null){
                jpqlQuery.where(qCode.codeId.eq(code.getCodeId()));
            }
            if(code.getParentId() != null){
                jpqlQuery.where(qCode.parentId.eq(code.getParentId()));
            }
            if(code.getCodeName() != null){
                jpqlQuery.where(qCode.codeName.like("%"+code.getCodeName()+"%"));
            }
            if(code.getEnabled() != null){
                jpqlQuery.where(qCode.enabled.eq(code.getEnabled()));
            }
            if(code.getDescription() != null){
                jpqlQuery.where(qCode.description.eq(code.getDescription()));
            }
        }



        return jpqlQuery.fetch();
    }
}
