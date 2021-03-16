package com.mrisk.monitoreo.application.repository.rule;

import java.util.List;

import com.mrisk.monitoreo.domain.rule.Rule;

public interface RuleRepository {
	
	List<Rule> getRuleAll();
	
	Rule findById(Integer id);

	Rule save(Rule rule);

}
