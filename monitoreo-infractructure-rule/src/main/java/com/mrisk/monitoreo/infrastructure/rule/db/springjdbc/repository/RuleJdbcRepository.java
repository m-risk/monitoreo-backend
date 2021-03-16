package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.rule.repository.RuleRepository;
import com.mrisk.monitoreo.rule.domain.Rule;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class RuleJdbcRepository implements RuleRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<Rule> getRuleAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public Rule findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rule save(Rule rule) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
