package com.telecom.user.exception;

public class OrderValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public OrderValidationException(String errorCode, Throwable t) {
		super("", t);
	}
	
	public OrderValidationException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
	public OrderValidationException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}


	public OrderValidationException(String errorCode, String errorMessage, Throwable t) {
		super(errorMessage, t);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
