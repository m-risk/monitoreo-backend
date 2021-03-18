package com.mrisk.monitoreo.application.repository.rule;

import java.util.List;

import com.mrisk.monitoreo.domain.rule.SubComponent;

public interface SubComponentRepository {

    SubComponent findById(Integer id);

    List<SubComponent> findAllSubComponentByComponentId(Integer compId);

    SubComponent findSubCompByCompIdAndSubId(Integer id, Integer csubid);

}
