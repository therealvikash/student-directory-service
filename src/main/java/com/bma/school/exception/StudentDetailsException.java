package com.bma.school.exception;

import lombok.Data;

@Data
public class StudentDetailsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String exceptionCode;
	private String exceptionType;
	private String message;

	public StudentDetailsException() {
		super();
	}	
	
	public StudentDetailsException(String exceptionCode, String exceptionType, String message) {
		super();
		this.exceptionCode = exceptionCode;
		this.exceptionType = exceptionType;
		this.message = message;
	}
}
