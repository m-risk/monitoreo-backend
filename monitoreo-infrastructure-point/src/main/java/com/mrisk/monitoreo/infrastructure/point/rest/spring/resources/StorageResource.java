package com.mrisk.monitoreo.infrastructure.point.rest.spring.resources;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.point.service.StorageService;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.DocumentDto;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.StorageDto;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.mapper.StorageMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StorageResource {
 
  private final StorageService storageService;
  private final StorageMapper storageMapper;
  
  @PostMapping("/points/{pointId}/storages")
  public ResponseEntity<StorageDto> saveStorage(@PathVariable Integer pointId, @RequestBody StorageDto storageDto) {
	  
	  storageDto.setPointId(pointId);
	  addSelfLink(storageDto);
	  return new ResponseEntity<>(storageMapper.toDto(storageService.saveStorage(storageMapper.toDomain(storageDto))),HttpStatus.CREATED);
  }

  
  @GetMapping("/points/{pointId}/storage")
  public ResponseEntity<StorageDto> singleSelectStorage(@PathVariable Integer pointId) {
	
	  StorageDto storageDto = storageMapper.toDto(storageService.getStorage(pointId));
	  addStorageLinks(storageDto);
	  
    return new ResponseEntity<>((storageDto), HttpStatus.OK);
  }
  private void addStorageLinks(StorageDto storageDto) {
      addSelfLink(storageDto);
      addStorageLink(storageDto);
      addDocumentLink(storageDto);
  }
  private void addSelfLink(StorageDto storageDto) {
	  storageDto.add(linkTo(methodOn(StorageResource.class).singleSelectStorage(storageDto.getId())).withSelfRel());
  }
  private void addStorageLink(StorageDto storageDto) {
	  storageDto.add(linkTo(methodOn(StorageResource.class).saveStorage(storageDto.getId(), new StorageDto())).withRel("storages"));
  }
  private void addDocumentLink(StorageDto storageDto) {
	  storageDto.add(linkTo(methodOn(DocumentResource.class).saveDocument(storageDto.getId(), new DocumentDto())).withRel("documents")); 
  }
}
