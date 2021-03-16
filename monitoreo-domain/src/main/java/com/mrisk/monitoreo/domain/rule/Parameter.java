package com.mrisk.monitoreo.domain.rule;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Parameter {

    private Integer paraId;
    private String name;
    private String symbol;
    private String unit;
    private boolean isDiscreet;
    
    private Integer tenaId;
    private Boolean alive = Boolean.TRUE;
    private Calendar creationTime = Calendar.getInstance();
    private Calendar modificationTime;
    private Calendar destructionTime;
}
