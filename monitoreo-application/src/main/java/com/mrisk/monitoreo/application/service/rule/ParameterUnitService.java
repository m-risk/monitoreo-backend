package com.mrisk.monitoreo.application.service.rule;

import java.util.List;

import com.mrisk.monitoreo.application.repository.rule.ParameterUnitRepository;
import com.mrisk.monitoreo.domain.rule.ParameterUnit;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParameterUnitService {

	private final ParameterUnitRepository repository;

	public List<ParameterUnit> getListParameterUnit() {

		return repository.getListParameterUnit();
		
	}

}
