package com.mrisk.monitoreo.application.rule.repository;

import java.util.List;

import com.mrisk.monitoreo.rule.domain.Parameter;

public interface ParameterRepository  {

	Parameter singleSelectParameter(Integer id);

    List<Parameter> findParametersByRequestsFilter(Integer compId, Integer csubId, String parameterName);

}
