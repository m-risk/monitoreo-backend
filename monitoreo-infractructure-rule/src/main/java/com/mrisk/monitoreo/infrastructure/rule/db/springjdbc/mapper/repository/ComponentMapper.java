package com.mrisk.monitoreo.infrastructure.rule.db.springjdbc.mapper.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mrisk.monitoreo.domain.rule.Component;

public class ComponentMapper implements RowMapper<Component> {

    @Override
    public Component mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Component component = new Component();
        component.setCompId(rs.getInt("comp_id"));
        component.setName(rs.getString("name"));
        return component;
    }
}
