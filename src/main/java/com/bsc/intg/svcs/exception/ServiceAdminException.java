package com.bsc.intg.svcs.exception;

public class ServiceAdminException extends Exception {

	private static final long serialVersionUID = 3417085483029423624L;
	
	String code;
	String message;
	
	public ServiceAdminException(String code, String message) {
		this.code=code;
		this.message=message;
	}
	
	ServiceAdminException(Exception e) {
		this.code="Error";
		this.message=e.getMessage();
	}
	
	public ErrorResponse getErrorResponse() {
		return new ErrorResponse(this.code, this.message);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
