package com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubComponentDTO {
    
    private Integer csubId;
    private String name;
    private String description;

}
