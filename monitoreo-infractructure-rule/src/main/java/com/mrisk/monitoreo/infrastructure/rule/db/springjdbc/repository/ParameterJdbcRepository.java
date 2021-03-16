package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mrisk.monitoreo.application.rule.repository.ParameterRepository;
import com.mrisk.monitoreo.rule.domain.Parameter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ParameterJdbcRepository implements ParameterRepository {

    private static final String SELECT_BASE_PARAMETER = "SELECT  para_id, p.csub_id, p.name, symbol,pu.name unit, discrete FROM parameter p join parameter_unit pu on (p.unit_id = pu.unit_id) where 1 = 1 ";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Parameter singleSelectParameter(Integer id) {

        String sql = SELECT_BASE_PARAMETER + " and para_id=?";
        try {

            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Parameter>(Parameter.class), id);

        } catch (EmptyResultDataAccessException noResult) {

            return null;
        }

    }

    @Override
    public List<Parameter> findParametersByRequestsFilter(Integer compId, Integer csubId, String parameterName) {

        try {

            String sql = createQueryForFilter(compId, csubId, parameterName);
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Parameter>(Parameter.class));

        } catch (EmptyResultDataAccessException noResult) {

            return new ArrayList<>();
        }
    }

    private String createQueryForFilter(Integer compId, Integer csubId, String parameterName) {
        StringBuilder sql = new StringBuilder(SELECT_BASE_PARAMETER);
        if (Objects.nonNull(compId)) {
            sql.append("and p.csub_id in (select csub_id from component_sub cs where comp_id  =" + compId + ")");
        }

        if (Objects.nonNull(csubId)) {
            sql.append("and csub_id =" + csubId + "");
        }

        if (Objects.nonNull(parameterName)) {
            sql.append("and p.name = '" + parameterName + "'");
        }
        return sql.toString();
    }

}
