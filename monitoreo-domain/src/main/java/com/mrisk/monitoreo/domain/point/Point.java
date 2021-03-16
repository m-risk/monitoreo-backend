package com.mrisk.monitoreo.domain.point;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Point {
	
	private Integer poin_id;
    private Integer tenaId;
    private Boolean alive = Boolean.TRUE;
    private Calendar creationTime = Calendar.getInstance();
    private Calendar modificationTime;
    private Calendar destructionTime;
    private Integer accoId;
    private Integer sectId;
    private String name;
    private String nameInternal;
    private String description;
    private Double coordinateX;
    private Double coordinateY;
    private String datum;
}