package com.mrisk.monitoreo.application.repository.point;

import java.util.List;

import com.mrisk.monitoreo.domain.point.Point;

public interface PointRepository {
	
	List<Point> massiveSelectPoint();
	
	Point singleSelectPoint(Integer id);

	Point save(Point point);

}
