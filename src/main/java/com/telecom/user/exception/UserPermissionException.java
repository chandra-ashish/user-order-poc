package com.telecom.user.exception;

public class UserPermissionException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public UserPermissionException(String errorCode, Throwable t) {
		super("", t);
	}


	public UserPermissionException(String errorCode, String errorMessage) {
		super();
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
