package com.bsc.intg.svcs.exception;

//added some comments
<<<<<<< HEAD
//add extra comments
=======
>>>>>>> 2748b4b89ea3533f1e352679878c81f384469a20
//added some more comments
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
