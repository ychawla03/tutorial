package com.example.Mappings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private String resourceName;
	private String fieldName;
	private Long fieldValue;
	
	public ResourceNotFoundException(String exMessage) {
		super(String.format("Exception %s", exMessage));
		this.fieldName = exMessage;
	}
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s:%s", resourceName, fieldName,
				fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
