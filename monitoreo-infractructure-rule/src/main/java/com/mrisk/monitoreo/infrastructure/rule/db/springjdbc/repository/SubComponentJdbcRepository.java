package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.repository.rule.SubComponentRepository;
import com.mrisk.monitoreo.domain.rule.SubComponent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubComponentJdbcRepository implements SubComponentRepository {

//    private static final String SELECT_COMP_BY_ID = "SELECT comp_id,name,description FROM component_sub where comp_id = ? and alive is true";
    private static final String SELECT_ALL_SUBCOMPONENT_BY_COMPONENT_ID = "SELECT csub_id,name,description FROM component_sub where comp_id = ? and alive is true";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SubComponent findById(Integer id) {
        return null;
    }

    @Override
    public List<SubComponent> findAllSubComponentByComponentId(Integer compId) {
        String sql = SELECT_ALL_SUBCOMPONENT_BY_COMPONENT_ID;
        try {

            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<SubComponent>(SubComponent.class), compId);

        } catch (EmptyResultDataAccessException noResult) {

            return new ArrayList<>();
        }
    }

}
