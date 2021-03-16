package com.mrisk.monitoreo.application.rule.service;

import java.util.Objects;

import com.mrisk.monitoreo.application.exception.DataNotFoundException;
import com.mrisk.monitoreo.application.rule.repository.ParameterRepository;
import com.mrisk.monitoreo.rule.domain.Parameter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParameterService {

    private static final String DATA_NOT_FOUND = "Data Not Found";
    private final ParameterRepository repository;

    public Parameter singleSelectParameter(Integer id) {
        Parameter objParameter = repository.singleSelectParameter(id);
        if (Objects.nonNull(objParameter)) {
            return objParameter;
        }
        throw new DataNotFoundException(DATA_NOT_FOUND);
    }

}
