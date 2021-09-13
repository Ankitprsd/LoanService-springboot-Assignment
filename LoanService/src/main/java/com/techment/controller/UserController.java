package com.techment.controller;



import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.LoanService;
import com.techment.entity.User;
import com.techment.exception.InvalidUserException;
import com.techment.service.ILoanService;
import com.techment.service.IuserService;


@RestController
@RequestMapping(value="/Login")
public class UserController {
	
	@Autowired
	IuserService userservice;
	
	@PostMapping(value="/userLogin")
	public ResponseEntity<User> login(@RequestBody User user) throws InvalidUserException
	{
		try {
			
		    userservice.login(user.getUsername(),user.getPassword());
		    return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			throw new InvalidUserException("username or password not found");
		}
	}
}
