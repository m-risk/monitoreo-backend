package com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParameterUnitDTO {

	private Integer unitId;
	private String name;
	private String description;
	
	
}
