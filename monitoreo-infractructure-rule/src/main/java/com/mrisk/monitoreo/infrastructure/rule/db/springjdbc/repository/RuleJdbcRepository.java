package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.repository.rule.RuleRepository;
import com.mrisk.monitoreo.domain.rule.Rule;

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
        SimpleJdbcInsert insert = new SimpleJdbcInsert(this.jdbcTemplate).withTableName("norm")
                .usingGeneratedKeyColumns("norm_id");

        SqlParameterSource parameters = new BeanPropertySqlParameterSource(rule);
        Number newId = insert.executeAndReturnKey(parameters);
        rule.setNormId(newId.intValue());
        return rule;
    }

}
