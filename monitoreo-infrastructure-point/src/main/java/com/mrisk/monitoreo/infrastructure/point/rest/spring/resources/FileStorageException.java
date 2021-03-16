package com.mrisk.monitoreo.infrastructure.point.rest.spring.resources;

public class FileStorageException extends RuntimeException {

	private static final long serialVersionUID = -8830309105069508778L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
