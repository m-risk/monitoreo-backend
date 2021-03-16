package com.mrisk.monitoreo.application.rule.repository;

import java.util.List;

import com.mrisk.monitoreo.rule.domain.Component;

public interface ComponentRepository {

    Component findById(Integer id);

    List<Component> findComponents();

}
