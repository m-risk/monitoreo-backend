package com.mrisk.monitoreo.application.service.rule;

import java.util.List;

import com.mrisk.monitoreo.application.exception.DataNotFoundException;
import com.mrisk.monitoreo.application.repository.rule.SubComponentRepository;
import com.mrisk.monitoreo.domain.rule.SubComponent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubComponentService {
    
    private static final String DATA_NOT_FOUND = "Data Not Found";
    private final SubComponentRepository repository;
    
    public List<SubComponent> findAllSubComponentByComponentId(Integer componentId) {
        List<SubComponent>  subComponentList = repository.findAllSubComponentByComponentId(componentId);
        if(subComponentList.isEmpty()) {
            throw new DataNotFoundException(DATA_NOT_FOUND);
        }
        return subComponentList; 
    }

}
