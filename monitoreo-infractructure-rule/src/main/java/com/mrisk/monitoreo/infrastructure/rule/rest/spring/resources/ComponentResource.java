package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.service.rule.ComponentService;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.ComponentDTO;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ComponentResource {

    private final ComponentService componentService;

    /**
     * Metodo para encontrar un componente por id
     * 
     * @param id
     * @return
     */
    @GetMapping("/components/{id}")
    public ResponseEntity<EntityModel<ComponentDTO>> findComponentById(@PathVariable Integer id) {

        ComponentDTO componentDto = Converter.getMapper().map(componentService.findComponentById(id),
                ComponentDTO.class);

        EntityModel<ComponentDTO> resource = EntityModel.of(componentDto,
                linkTo(methodOn(SubComponentResource.class).findAllSubComponentByComponentId(componentDto.getCompId()))
                        .withRel("Subcomponents"));

        return new ResponseEntity<>((resource), HttpStatus.OK);
    }

    /**
     * Metodo para obtener todos los componentes
     * 
     * @return
     */
    @GetMapping("/components")
    public ResponseEntity<List<EntityModel<ComponentDTO>>> findComponents() {

        List<EntityModel<ComponentDTO>> listComponents = componentService.findComponents().stream()
                .map(component -> EntityModel.of(Converter.getMapper().map(component, ComponentDTO.class),
                        linkTo(methodOn(ComponentResource.class).findComponentById(component.getCompId()))
                                .withSelfRel(),
                        linkTo(methodOn(SubComponentResource.class)
                                .findAllSubComponentByComponentId(component.getCompId())).withRel("Subcomponents")))
                .collect(Collectors.toList());

        return new ResponseEntity<>(listComponents, HttpStatus.OK);
    }

}