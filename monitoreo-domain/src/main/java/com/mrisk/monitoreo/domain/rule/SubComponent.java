package com.mrisk.monitoreo.domain.rule;

import java.util.Calendar;

import lombok.Data;

@Data
public class SubComponent {

    private Integer csubId;
    private String name;
    private String description;

    private Integer tenaId;
    private Boolean alive = Boolean.TRUE;
    private Calendar creationTime = Calendar.getInstance();
    private Calendar modificationTime;
    private Calendar destructionTime;

}
