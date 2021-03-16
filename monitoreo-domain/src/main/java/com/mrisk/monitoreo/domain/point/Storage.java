package com.mrisk.monitoreo.domain.point;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Storage {

	private Integer id;
	private String name;
	private String type;
	private String encoding;
	private String contentType;
	private Integer pointId;
	
	private Integer tenaId;
    private Boolean alive = Boolean.TRUE;
    private Calendar creationTime = Calendar.getInstance();
    private Calendar modificationTime;
    private Calendar destructionTime;
    
}
