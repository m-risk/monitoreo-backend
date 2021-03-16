package com.mrisk.monitoreo.infrastructure.point.rest.spring.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.DocumentDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DocumentResource {

//  private final StorageService storageService;

//  private final StorageMapper storageMapper;
  
  
  @PostMapping("/points/{pointId}/documents")
  public ResponseEntity<DocumentDto> saveDocument(@PathVariable Integer pointId, @RequestBody DocumentDto documentDto) {	  
//    return new ResponseEntity<>(storageMapper.toDto(storageService.saveStorage(storageMapper.toDomain(documentDto))),HttpStatus.CREATED);
	  return new ResponseEntity<>( HttpStatus.OK);
  }

}
