package com.psc.cloud.product.service;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CodeService {

    List<Code> list(Code code);

    void add(Code code);

    void update(Code code);

    void delete(Code code);
}
