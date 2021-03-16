package com.mrisk.monitoreo.infrastructure.point.config.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mrisk.monitoreo.application.repository.point.PointRepository;
import com.mrisk.monitoreo.application.repository.point.StorageRepository;
import com.mrisk.monitoreo.application.service.point.PointService;
import com.mrisk.monitoreo.application.service.point.StorageService;

@Configuration
public class SpringBootServiceConfig {


  @Bean
  public PointService pointService(PointRepository pointRepository) {
    return new PointService(pointRepository);
  }
 
  @Bean
  public StorageService storageService(StorageRepository storageRepository) {
    return new StorageService(storageRepository);
  }
  
}