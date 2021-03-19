package com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComponentDTO{
    
    private Integer compId;
    private String name;
    private String description;

}
