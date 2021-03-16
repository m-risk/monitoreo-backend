package com.mrisk.monitoreo.infrastructure.point.db.springjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mrisk.monitoreo.domain.point.Point;


public class PointMapper implements RowMapper<Point> {
    @Override
    public Point mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Point point = new Point();
        point.setPoin_id(rs.getInt("poin_id"));
        point.setTenaId(rs.getInt("tena_id"));
        point.setAlive(rs.getBoolean("alive"));
       point.setAccoId(rs.getInt("acco_id"));      
        point.setName(rs.getString("name"));
        point.setNameInternal(rs.getString("name_internal"));
        point.setSectId(rs.getInt("sect_id"));
        point.setDescription(rs.getString("description"));
        return point;
    }


}
