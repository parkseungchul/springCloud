package com.psc.cloud.product.service.impl;

import com.psc.cloud.product.domain.Code;
import com.psc.cloud.product.domain.Product;
import com.psc.cloud.product.repository.CodeRepository;
import com.psc.cloud.product.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeRepository codeRepository;

    @Override
    public List<Code> list(Code code) {
        return codeRepository.listCode(code);
    }

    @Override
    public void add(Code code) {

    }

    @Override
    public void update(Code code) {

    }

    @Override
    public void delete(Code code) {

    }
}
