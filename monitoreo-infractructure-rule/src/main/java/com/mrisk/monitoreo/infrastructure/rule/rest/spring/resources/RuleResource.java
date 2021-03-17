package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.service.rule.RuleService;
import com.mrisk.monitoreo.domain.rule.Rule;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.RuleDto;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class RuleResource {

    private final RuleService ruleService;

    @PostMapping("/rules")
    public ResponseEntity<?> saveRule(@RequestBody RuleDto ruleDTO) {

        RuleDto ruleCreated = Converter.getMapper().map(ruleService.saveRule(Converter.getMapper().map(ruleDTO, Rule.class)),
                RuleDto.class);
//        EntityModel<RuleDto> resource = EntityModel.of(ruleCreated);
//        addSelfLink(resource);
        return new ResponseEntity<>(ruleCreated,HttpStatus.CREATED);
    }
    
//    private void addSelfLink(EntityModel<RuleDto> resource) {
//        
//        Integer id = resource.getContent().getNormId();
//        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).singleSelectPoint(id)).withSelfRel());
//    }

}
