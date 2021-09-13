package com.techment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=LoanServiceAlreadyExists.class)
	public ResponseEntity<String> myException(LoanServiceAlreadyExists exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=LoanServiceNotFoundException.class)
	public ResponseEntity<String> exceptionNotFound(LoanServiceNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMsg(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidUserException.class)
	public ResponseEntity<String> invalidException(InvalidUserException exception)
	{
		return new ResponseEntity<String>(exception.getMsg1(),HttpStatus.UNAUTHORIZED);
	}

}
