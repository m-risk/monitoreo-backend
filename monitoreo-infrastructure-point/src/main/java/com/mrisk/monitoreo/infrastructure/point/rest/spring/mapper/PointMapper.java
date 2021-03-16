package com.mrisk.monitoreo.infrastructure.point.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.PointDto;
import com.mrisk.monitoreo.point.domain.Point;

@Mapper(componentModel = "spring")
public interface PointMapper {

  PointDto toDto (Point point);

  Point toDomain(PointDto pointDto);
}
