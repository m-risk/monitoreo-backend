package com.mrisk.monitoreo.application.service.point;

import java.util.List;

import com.mrisk.monitoreo.application.repository.point.StorageRepository;
import com.mrisk.monitoreo.domain.point.Storage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StorageService {

  private final StorageRepository repository;
  
  public List<Storage> getStorageAll() {
	    return repository.getStorageAll();
  }
  
  public Storage getStorage(Integer id) {
    return repository.findById(id);
  }

  public Storage saveStorage(Storage storage) {

    return repository.save(storage);

  }
}
