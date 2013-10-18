package com.app.web.exception;

public class GenericException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	private String errCode;
	private String errMsg;
 
	//getter and setter methods
 
	public GenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
 
}