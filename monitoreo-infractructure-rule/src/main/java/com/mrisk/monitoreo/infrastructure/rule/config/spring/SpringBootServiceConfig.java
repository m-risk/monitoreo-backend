package com.mrisk.monitoreo.infrastructure.rule.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mrisk.monitoreo.application.repository.rule.ComponentRepository;
import com.mrisk.monitoreo.application.repository.rule.ParameterRepository;
import com.mrisk.monitoreo.application.repository.rule.ParameterUnitRepository;
import com.mrisk.monitoreo.application.repository.rule.RuleRepository;
import com.mrisk.monitoreo.application.repository.rule.SubComponentRepository;
import com.mrisk.monitoreo.application.service.rule.ComponentService;
import com.mrisk.monitoreo.application.service.rule.ParameterService;
import com.mrisk.monitoreo.application.service.rule.ParameterUnitService;
import com.mrisk.monitoreo.application.service.rule.RuleService;
import com.mrisk.monitoreo.application.service.rule.SubComponentService;

@Configuration
public class SpringBootServiceConfig {

    @Bean
    public RuleService ruleService(RuleRepository ruleRepository) {
        return new RuleService(ruleRepository);
    }

    @Bean
    public ParameterService parameterService(ParameterRepository parameterRepository) {
        return new ParameterService(parameterRepository);
    }

    @Bean
    public ParameterUnitService parameterUnitService(ParameterUnitRepository parameterUnitRepository) {
        return new ParameterUnitService(parameterUnitRepository);
    }

    @Bean
    public ComponentService componentService(ComponentRepository componentRepository) {
        return new ComponentService(componentRepository);
    }

    @Bean
    public SubComponentService subComponentService(SubComponentRepository subComponentRepository) {
        return new SubComponentService(subComponentRepository);
    }

}