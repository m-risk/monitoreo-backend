package com.mrisk.monitoreo.application.repository.rule;

import java.util.List;

import com.mrisk.monitoreo.domain.rule.Parameter;

public interface ParameterRepository  {

	Parameter singleSelectParameter(Integer id);

    List<Parameter> findParametersByRequestsFilter(Integer compId, Integer csubId, String parameterName);

}
