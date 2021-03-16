package com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ParameterUnitDTO  extends RepresentationModel<ParameterUnitDTO>{

	private Integer unitId;
	private String name;
	private String description;
	
//	private Integer tenaId;
//	private Boolean alive = Boolean.TRUE;
//	private Calendar creationTime = Calendar.getInstance();
//	private Calendar modificationTime;
//	private Calendar destructionTime;
	
	
}
