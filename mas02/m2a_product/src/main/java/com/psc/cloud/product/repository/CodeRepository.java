package com.psc.cloud.product.repository;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.repository.custom.CustomCode;
import org.springframework.data.repository.CrudRepository;

public interface CodeRepository extends CrudRepository<Code, Long>, CustomCode {

    Code findByCodeName(String codeName);
}
