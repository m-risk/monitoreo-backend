package com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ComponentDTO extends RepresentationModel<ComponentDTO>{
    
    private Integer compId;
    private String name;
    private String description;

}
