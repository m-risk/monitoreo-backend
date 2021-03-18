package com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RuleDto {

    private Integer normId;
    private String name;
    private Integer compId;
    private Integer csubId;
    private String detail;
    private String description;


}
