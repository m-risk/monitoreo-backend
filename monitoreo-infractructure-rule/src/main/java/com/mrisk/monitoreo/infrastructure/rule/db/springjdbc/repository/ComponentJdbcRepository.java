package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.rule.repository.ComponentRepository;
import com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.mapper.repository.ComponentMapper;
import com.mrisk.monitoreo.rule.domain.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ComponentJdbcRepository implements ComponentRepository {

    private static final String SELECT_COMP_BY_ID = "SELECT comp_id,name,description FROM component where comp_id = ? and alive is true";
    private static final String SELECT_ALL_COMPONENT = "SELECT comp_id,name,description FROM component where alive is true";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Component findById(Integer id) {
        String sql = SELECT_COMP_BY_ID;
        try {

            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Component>(Component.class), id);

        } catch (EmptyResultDataAccessException noResult) {

            return null;
        }
    }

    @Override
    public List<Component> findComponents() {
        String sql = SELECT_ALL_COMPONENT;
        try {

            return jdbcTemplate.query(sql, new ComponentMapper());

        } catch (EmptyResultDataAccessException noResult) {

            return new ArrayList<>();
        }
    }

}
