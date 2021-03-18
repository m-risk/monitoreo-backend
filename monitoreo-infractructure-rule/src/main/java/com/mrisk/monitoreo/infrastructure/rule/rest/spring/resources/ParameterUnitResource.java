package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.service.rule.ParameterUnitService;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.ParameterUnitDTO;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ParameterUnitResource {

	private final ParameterUnitService parameterUnitService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/parameters/unit")
	public ResponseEntity<List<ParameterUnitDTO>> singleSelectRule() {

		List<ParameterUnitDTO> parameterUnitList = parameterUnitService.getListParameterUnit().stream()
				.map(x -> Converter.getMapper().map(x, ParameterUnitDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>((parameterUnitList), HttpStatus.OK);
	}


}
