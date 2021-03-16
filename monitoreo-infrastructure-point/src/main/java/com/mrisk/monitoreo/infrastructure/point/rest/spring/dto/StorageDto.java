package com.mrisk.monitoreo.infrastructure.point.rest.spring.dto;

import java.util.Calendar;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StorageDto extends RepresentationModel<StorageDto>{
  private Integer id;
  private String name;
  private String type;
  private String encoding;
  private String contentType;
  private Integer pointId;
  
  private Integer tenaId;
  private Boolean alive = Boolean.TRUE;
  private Calendar creationTime = Calendar.getInstance();
  private Calendar modificationTime;
  private Calendar destructionTime;
  
}
