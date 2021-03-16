package com.mrisk.monitoreo.application.repository.rule;

import java.util.List;

import com.mrisk.monitoreo.domain.rule.Component;

public interface ComponentRepository {

    Component findById(Integer id);

    List<Component> findComponents();

}
