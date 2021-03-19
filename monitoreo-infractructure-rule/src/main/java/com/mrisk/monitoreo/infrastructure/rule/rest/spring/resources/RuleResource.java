package com.mrisk.monitoreo.infrastructure.rule.rest.spring.resources;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.service.rule.RuleService;
import com.mrisk.monitoreo.domain.rule.Rule;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.dto.RuleDto;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.mapper.Converter;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class RuleResource {

    private final RuleService ruleService;
    
    
 
    /**
     * Metodo que permite crear una norma interna
     * @param ruleDTO
     * @return
     */
    @ApiOperation(value = "create internal rule")
    @PostMapping(value="/rules",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<RuleDto>> saveRule(@RequestBody RuleDto ruleDTO) {

        RuleDto ruleCreated = Converter.getMapper().map(ruleService.saveRule(Converter.getMapper().map(ruleDTO, Rule.class)),
                RuleDto.class);
        
        EntityModel<RuleDto> resource = EntityModel.of(ruleCreated);
        return new ResponseEntity<>(resource,HttpStatus.CREATED);
    }
    

}
