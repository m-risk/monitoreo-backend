package com.mrisk.monitoreo.application.point.service;

import java.util.List;

import com.mrisk.monitoreo.application.point.repository.PointRepository;
import com.mrisk.monitoreo.point.domain.Point;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PointService {

  private final PointRepository pointRepository;
  
  public List<Point> massiveSelectPoint() {
	    return pointRepository.massiveSelectPoint();
  }
  
  public Point singleSelectPoint(Integer id) {
    return pointRepository.singleSelectPoint(id);
  }

  public Point savePoint(Point point) {

    return pointRepository.save(point);

  }
}
