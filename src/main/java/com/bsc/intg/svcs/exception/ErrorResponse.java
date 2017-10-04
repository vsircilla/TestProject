package com.bsc.intg.svcs.exception;

//added some comments
public class ErrorResponse {
	
	String code;
	String messgae;
	
	public ErrorResponse(String code, String message) {
		this.code=code;
		this.messgae=message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	
}
