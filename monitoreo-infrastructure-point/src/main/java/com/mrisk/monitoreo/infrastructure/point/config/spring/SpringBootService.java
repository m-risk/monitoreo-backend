package com.mrisk.monitoreo.infrastructure.point.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mrisk.monitoreo.infrastructure.point.rest.spring.resources.FileStorageProperties;

@SpringBootApplication(scanBasePackages = "com.mrisk.monitoreo.infrastructure.point")
@EntityScan(basePackages = "com.mrisk.monitoreo.domain")
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class SpringBootService {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootService.class, args);
  }

}