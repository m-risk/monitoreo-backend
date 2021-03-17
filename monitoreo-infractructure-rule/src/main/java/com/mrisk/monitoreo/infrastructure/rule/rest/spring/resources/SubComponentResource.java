package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.service.rule.SubComponentService;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.SubComponentDTO;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SubComponentResource {
    
    private final SubComponentService subComponentService;
    
    @GetMapping("/components/{id}/subcomponents")
    public ResponseEntity<List<SubComponentDTO>> findAllSubComponentByComponentId(@PathVariable Integer id) {

        List<SubComponentDTO> listParameters = subComponentService.findAllSubComponentByComponentId(id).stream()
                .map(c -> Converter.getMapper().map(c, SubComponentDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(listParameters, HttpStatus.OK);
    }

}
