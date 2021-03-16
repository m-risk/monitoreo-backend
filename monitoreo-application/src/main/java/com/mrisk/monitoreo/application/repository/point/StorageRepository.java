package com.mrisk.monitoreo.application.repository.point;

import java.util.List;

import com.mrisk.monitoreo.domain.point.Storage;

public interface StorageRepository {
	
	List<Storage> getStorageAll();
	
	Storage findById(Integer id);

	Storage save(Storage storage);

}
