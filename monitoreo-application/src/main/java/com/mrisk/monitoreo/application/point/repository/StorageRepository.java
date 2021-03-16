package com.mrisk.monitoreo.application.point.repository;

import java.util.List;

import com.mrisk.monitoreo.point.domain.Storage;

public interface StorageRepository {
	
	List<Storage> getStorageAll();
	
	Storage findById(Integer id);

	Storage save(Storage storage);

}
