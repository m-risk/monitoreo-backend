package com.mrisk.monitoreo.infrastructure.rule.rest.spring.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDTO {

	private String type;
	private String description;

}
