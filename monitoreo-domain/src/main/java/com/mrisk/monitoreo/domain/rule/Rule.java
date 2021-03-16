package com.mrisk.monitoreo.domain.rule;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rule {

	private Integer ruleId;
	private Integer tenaId;
	private Boolean alive = Boolean.TRUE;
	private Calendar creationTime = Calendar.getInstance();
	private Calendar modificationTime;
	private Calendar destructionTime;
	private String name;
}
