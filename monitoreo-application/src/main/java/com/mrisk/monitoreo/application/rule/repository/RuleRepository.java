package com.mrisk.monitoreo.application.rule.repository;

import java.util.List;

import com.mrisk.monitoreo.rule.domain.Rule;

public interface RuleRepository {
	
	List<Rule> getRuleAll();
	
	Rule findById(Integer id);

	Rule save(Rule rule);

}
