package com.techment.exception;

public class LoanServiceAlreadyExists extends RuntimeException{
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoanServiceAlreadyExists(String message) {
		super();
		this.message = message;
	}
	
	

}
