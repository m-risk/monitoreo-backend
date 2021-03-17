package com.mrisk.monitoreo.application.service.rule;

import java.util.List;
import java.util.Objects;

import com.mrisk.monitoreo.application.exception.DataNotFoundException;
import com.mrisk.monitoreo.application.repository.rule.ComponentRepository;
import com.mrisk.monitoreo.domain.rule.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ComponentService {
    private final ComponentRepository repository;
    private static final String DATA_NOT_FOUND = "Data Not Found";

    public Component findComponentById(Integer id) {
        Component objComponent = repository.findById(id);
        if (Objects.nonNull(objComponent)) {
            return objComponent;
        }
        throw new DataNotFoundException(DATA_NOT_FOUND);
    }

    public List<Component> findComponents() {
        List<Component> listComponent = repository.findComponents();
        if (listComponent.isEmpty()) {
            throw new DataNotFoundException(DATA_NOT_FOUND);
        }
      
        return listComponent;
    }
}
