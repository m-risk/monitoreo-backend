package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.rule.service.ComponentService;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.ComponentDTO;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ComponentResource {

    private final ComponentService componentService;

    @GetMapping("/components/{id}")
    public ResponseEntity<EntityModel<ComponentDTO>> findComponentById(@PathVariable Integer id) {

        ComponentDTO parameterDto = Converter.getMapper().map(componentService.findComponentById(id),
                ComponentDTO.class);

        EntityModel<ComponentDTO> resource = EntityModel.of(parameterDto);

        return new ResponseEntity<>((resource), HttpStatus.OK);
    }

    @GetMapping("/components")
    public ResponseEntity<List<ComponentDTO>> findComponents() {

        List<ComponentDTO> listParameters = componentService.findComponents().stream()
                .map(c -> Converter.getMapper().map(c, ComponentDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(listParameters, HttpStatus.OK);
    }

}