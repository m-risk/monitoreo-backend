package com.mrisk.monitoreo.infrastructure.point.rest.spring.resources;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrisk.monitoreo.application.point.service.PointService;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.PointDto;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.mapper.PointMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PointResource {

  private final PointService pointService;
  private final PointMapper pointMapper;
  
//  @GetMapping("/points")
//  public ResponseEntity<PointDto> getPointAll() {
//	  System.out.println(pointService.getPointAll().size());
////    return new ResponseEntity<>(pointMapper.toDto(pointService.getPointAll()), HttpStatus.OK);
//	  return new ResponseEntity<>( HttpStatus.OK);
//  } 
  
  
  @GetMapping("/points/{id}")
  public ResponseEntity<?> singleSelectPoint(@PathVariable Integer id) {
	   
	  PointDto pointDto = pointMapper.toDto(pointService.singleSelectPoint(id));
	  
	  EntityModel<PointDto> resource = EntityModel.of(pointDto); 
	  addPointLinks(resource);
    return new ResponseEntity<>((resource), HttpStatus.OK);
  }
  
  @PostMapping("/points")
  public ResponseEntity<?> savePoint(@RequestBody PointDto pointDto) {
	   
	  PointDto pointDtoNew = pointMapper.toDto(pointService.savePoint(pointMapper.toDomain(pointDto)));
	  EntityModel<PointDto> resource = EntityModel.of(pointDtoNew);
	  addSelfLink(resource);
    return new ResponseEntity<>((resource), HttpStatus.CREATED);
  }
  private void addPointLinks(EntityModel<PointDto> resource) {
	  
      addSelfLink(resource);
      addStorageLink(resource);
      addDocumentLink(resource);
  }
  private void addSelfLink(EntityModel<PointDto> resource) {
	  
	  Integer id = resource.getContent().getPoin_id();
	  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).singleSelectPoint(id)).withSelfRel());
  }
  private void addStorageLink(EntityModel<PointDto> resource) {
	 
	  Integer id = resource.getContent().getPoin_id();
//	  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StorageResource.class).saveStorage(id, new StorageDto())).withRel("storages"));
	  
//	  MultipartFile mockMultipartFile = new MockMultipartFile("test.txt","Hallo World".getBytes()); //content
	  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FileController.class).uploadFile(id, null)).withRel("uploadFile"));
	  
	  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FileController.class).delete(id, "1d2fee30-253d-4ed2-a347-08ae48263edb")).withRel("delete"));
	  
  }
  private void addDocumentLink(EntityModel<PointDto> resource) {
	  Integer id = resource.getContent().getPoin_id();
	  
//	  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DocumentResource.class).saveDocument(id, new DocumentDto())).withRel("documents"));
	  resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(FileController.class).uploadMultipleFiles(id, null)).withRel("uploadDocuments"));
  }
}