package com.mrisk.monitoreo.infrastructure.rule.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mrisk.monitoreo.application.rule.repository.ComponentRepository;
import com.mrisk.monitoreo.application.rule.repository.ParameterRepository;
import com.mrisk.monitoreo.application.rule.repository.ParameterUnitRepository;
import com.mrisk.monitoreo.application.rule.repository.RuleRepository;
import com.mrisk.monitoreo.application.rule.service.ComponentService;
import com.mrisk.monitoreo.application.rule.service.ParameterService;
import com.mrisk.monitoreo.application.rule.service.ParameterUnitService;
import com.mrisk.monitoreo.application.rule.service.RuleService;

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

}