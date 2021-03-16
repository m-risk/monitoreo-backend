package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.rule.repository.ParameterRepository;
import com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.mapper.repository.ParameterMapper;
import com.mrisk.monitoreo.rule.domain.Parameter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ParameterJdbcRepository implements ParameterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Parameter singleSelectParameter(Integer id) {

        String sql = "SELECT p.tena_id, para_id, p.alive, p.creation_time, p.modification_time, p.destruction_time, p.csub_id, p.name, symbol,pu.name unit_name, discrete FROM parameter p join parameter_unit pu on (p.unit_id = pu.unit_id) where para_id=?";
        try {

            return jdbcTemplate.queryForObject(sql, new ParameterMapper(), id);

        } catch (EmptyResultDataAccessException noResult) {

            return null;
        }

    }

}
