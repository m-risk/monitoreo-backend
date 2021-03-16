package com.mrisk.monitoreo.application.rule.repository;

import com.mrisk.monitoreo.rule.domain.Parameter;

public interface ParameterRepository  {

	Parameter singleSelectParameter(Integer id);

}
