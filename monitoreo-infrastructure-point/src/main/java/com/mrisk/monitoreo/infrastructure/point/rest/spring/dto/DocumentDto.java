package com.mrisk.monitoreo.infrastructure.point.rest.spring.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto extends RepresentationModel<DocumentDto>{
  private Long id;
  private String name;
}
