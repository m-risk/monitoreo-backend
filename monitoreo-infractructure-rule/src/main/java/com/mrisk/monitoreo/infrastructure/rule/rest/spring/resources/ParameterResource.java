package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.service.rule.ParameterService;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.ParameterDto;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ParameterResource {

    private final ParameterService parameterService;

    @GetMapping("/parameters/{id}")
    public ResponseEntity<EntityModel<ParameterDto>> singleSelectRule(@PathVariable Integer id) {

        ParameterDto parameterDto = Converter.getMapper().map(parameterService.singleSelectParameter(id),
                ParameterDto.class);

        EntityModel<ParameterDto> resource = EntityModel.of(parameterDto);

        addSelfLink(resource);

        return new ResponseEntity<>((resource), HttpStatus.OK);
    }

    @GetMapping("/parameters/")
    public ResponseEntity<List<ParameterDto>> findParametersByRequestFilter(@RequestParam(required = false) Integer compId,
            @RequestParam(required = false) Integer csubId, @RequestParam(required = false) String name ) {

        List<ParameterDto> listParameters = parameterService.findParametersByRequestsFilter(compId,csubId,name).stream()
                .map(c -> Converter.getMapper().map(c, ParameterDto.class)).collect(Collectors.toList());

        return new ResponseEntity<>(listParameters, HttpStatus.OK);
    }

    private void addSelfLink(EntityModel<ParameterDto> resource) {
        Long id = resource.getContent().getParaId();
        resource.add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).singleSelectRule(id.intValue())).withSelfRel());
    }

}