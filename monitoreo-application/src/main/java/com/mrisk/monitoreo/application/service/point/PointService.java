package com.mrisk.monitoreo.application.service.point;

import java.util.List;

import com.mrisk.monitoreo.application.repository.point.PointRepository;
import com.mrisk.monitoreo.domain.point.Point;

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
