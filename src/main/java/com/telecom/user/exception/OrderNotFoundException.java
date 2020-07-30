package com.telecom.user.exception;

public class OrderNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public OrderNotFoundException(String errorCode, Throwable t) {
		super("", t);
	}

	public OrderNotFoundException(String errorCode, String errorMessage, Throwable t) {
		super(errorMessage, t);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		System.out.println("BaseTSLException-1");
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
