package com.mrisk.monitoreo.application.service.rule;

import java.util.List;

import com.mrisk.monitoreo.application.repository.rule.RuleRepository;
import com.mrisk.monitoreo.domain.rule.Rule;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuleService {

    private static final int INTERN_RULE_TYPE = 1;
    private final RuleRepository repository;

    public List<Rule> getRuleAll() {
        return repository.getRuleAll();
    }

    public Rule singleSelectRule(Integer id) {
        return repository.findById(id);
    }

    public Rule saveRule(Rule rule) {
        // TODO : se debe reemplazar valores seteados en duro por el correcto
        rule.setTenaId(1);
        rule.setAccoId(1);
        rule.setTypeId(INTERN_RULE_TYPE);
        rule.setLegal(Boolean.FALSE);
        return repository.save(rule);

    }
}
