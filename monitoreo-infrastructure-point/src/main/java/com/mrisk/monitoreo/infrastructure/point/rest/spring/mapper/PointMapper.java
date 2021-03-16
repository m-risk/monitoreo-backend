package com.mrisk.monitoreo.infrastructure.point.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.mrisk.monitoreo.domain.point.Point;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.PointDto;

@Mapper(componentModel = "spring")
public interface PointMapper {

  PointDto toDto (Point point);

  Point toDomain(PointDto pointDto);
}
