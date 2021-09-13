package com.techment.exception;

public class LoanServiceNotFoundException extends RuntimeException {
	
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LoanServiceNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
