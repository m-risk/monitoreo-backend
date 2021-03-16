package com.mrisk.monitoreo.application.point.repository;

import java.util.List;

import com.mrisk.monitoreo.point.domain.Point;

public interface PointRepository {
	
	List<Point> massiveSelectPoint();
	
	Point singleSelectPoint(Integer id);

	Point save(Point point);

}
