package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.repository.rule.ParameterUnitRepository;
import com.mrisk.monitoreo.domain.rule.ParameterUnit;

@Service
public class ParameterUnitJdbcRepository implements ParameterUnitRepository {

	private static final String SELECT_ALL_PARAMETER_UNIT = "select unit_id,name,description from parameter_unit";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ParameterUnit> getListParameterUnit() {

		return jdbcTemplate.query(SELECT_ALL_PARAMETER_UNIT,
				new BeanPropertyRowMapper<ParameterUnit>(ParameterUnit.class));
	}

}
