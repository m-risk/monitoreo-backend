package com.mrisk.monitoreo.application.rule.service;

import java.util.List;

import com.mrisk.monitoreo.application.rule.repository.RuleRepository;
import com.mrisk.monitoreo.rule.domain.Rule;

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
