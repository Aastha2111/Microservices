package org.ncu.hirewheels.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	
	public UserNotFoundException(String resourceName) {
		super(String.format("%s not found ", resourceName));
		this.resourceName = resourceName;
		
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	
}
