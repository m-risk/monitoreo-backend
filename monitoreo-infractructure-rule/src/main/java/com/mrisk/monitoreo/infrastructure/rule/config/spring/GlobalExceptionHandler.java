package com.mrisk.monitoreo.infrastructure.rule.config.spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mrisk.monitoreo.application.exception.BusinessException;
import com.mrisk.monitoreo.application.exception.DataNotFoundException;
import com.mrisk.monitoreo.infrastructure.rule.rest.spring.exception.dto.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Gestiona las excepciones previamente enmascadas como BussinessException para
	 * su representación como ResponseEnity
	 * 
	 * @param Exception e; excepción a gestionar.
	 * 
	 * @return retorna un ResponseEntity<ExceptionDTO>, con la excepción capturada
	 *         sin nuevos enmascaramientos
	 * 
	 */
	@ExceptionHandler({ BusinessException.class })
	public ResponseEntity<ExceptionDTO> businessExceptionErrorHandler(Exception e) {
		ExceptionDTO exception = new ExceptionDTO(e.getClass().getSimpleName(), e.getMessage());
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ DataNotFoundException.class })
	public ResponseEntity<ExceptionDTO> dataNotFoundExceptionErrorHandler(Exception e) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
