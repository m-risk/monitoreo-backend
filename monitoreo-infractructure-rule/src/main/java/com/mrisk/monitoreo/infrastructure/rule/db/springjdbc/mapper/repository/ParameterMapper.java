package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.mapper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mrisk.monitoreo.rule.domain.Parameter;

public class ParameterMapper implements RowMapper<Parameter> {

    @Override
    public Parameter mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Parameter parameter = new Parameter();
        parameter.setParaId(rs.getInt("para_id"));
        parameter.setName(rs.getString("name"));
        parameter.setSymbol(rs.getString("symbol"));
        parameter.setUnit(rs.getString("unit_name"));
        parameter.setDiscreet(rs.getBoolean("discrete"));
        return parameter;
    }
}
