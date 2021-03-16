package com.mrisk.monitoreo.application.service.rule;

import java.util.List;

import com.mrisk.monitoreo.application.repository.rule.RuleRepository;
import com.mrisk.monitoreo.domain.rule.Rule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuleService {

  private final RuleRepository repository;
  
  public List<Rule> getRuleAll() {
	    return repository.getRuleAll();
  }
  
  public Rule singleSelectRule(Integer id) {
    return repository.findById(id);
  }

  public Rule saveRule(Rule rule) {

    return repository.save(rule);

  }
}
