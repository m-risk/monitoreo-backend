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
public class RuleDto extends RepresentationModel<RuleDto> {

    private Integer normId;
    private String name;
    private Integer compId;
    private Integer csubId;
    private String detail;
    private String description;

    private Boolean legal;

    private Integer ruleTypeId;


}
