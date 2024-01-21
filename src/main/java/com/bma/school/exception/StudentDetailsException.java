package com.bma.school.exception;

public class StudentDetailsException extends RuntimeException {

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

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
