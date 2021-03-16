package com.mrisk.monitoreo.application.rule.service;

import java.util.List;
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

    public List<Parameter> findParametersByRequestsFilter(Integer compId, Integer csubId, String parameterName) {
        List<Parameter> listParameters = repository.findParametersByRequestsFilter(compId, csubId, parameterName);
        if (listParameters.isEmpty()) {
            throw new DataNotFoundException(DATA_NOT_FOUND);
        }
        return listParameters;
    }

}
