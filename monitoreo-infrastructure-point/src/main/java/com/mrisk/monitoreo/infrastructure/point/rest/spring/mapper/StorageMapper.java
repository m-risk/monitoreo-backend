package com.mrisk.monitoreo.infrastructure.point.rest.spring.mapper;

import org.mapstruct.Mapper;

import com.mrisk.monitoreo.domain.point.Storage;
import com.mrisk.monitoreo.infrastructure.point.rest.spring.dto.StorageDto;

@Mapper(componentModel = "spring")
public interface StorageMapper { 

	StorageDto toDto (Storage storage);
	
	Storage toDomain(StorageDto storageDto);
}
