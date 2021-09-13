package com.techment.exception;

public class InvalidUserException extends RuntimeException {
	
	String msg1;

	public String getMsg1() {
		return msg1;
	}

	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}

	public InvalidUserException(String msg1) {
		super();
		this.msg1 = msg1;
	}
	
	

}
