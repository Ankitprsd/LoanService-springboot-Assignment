package com.techment.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.techment.entity.LoanService;
import com.techment.entity.User;
import com.techment.exception.InvalidUserException;
import com.techment.exception.LoanServiceAlreadyExists;
import com.techment.exception.LoanServiceNotFoundException;
import com.techment.repository.UserRepository;
import com.techment.service.ILoanService;
import com.techment.service.IuserService;

@RestController
@RequestMapping(value="/api/v1")
public class LoanServiceController {
	
	@Autowired
	ILoanService iloanservice;
	
	@Autowired
	IuserService iuserservice;
	
	@Autowired
	UserRepository userrepository;
	
	
	
	@PostMapping(value="/savingLoan")
	public ResponseEntity<LoanService> saveLoan(@RequestBody LoanService loanservice,@RequestHeader String token)
	{
		try {

			Optional<User> user = iuserservice.findBytoken(token);
			
			if (user==null) {
			throw new LoanServiceAlreadyExists("token is incorrect");
			}
			else {
				LoanService newLoanservice = iloanservice.saveLoanService(loanservice);
				return new ResponseEntity<LoanService>(newLoanservice, HttpStatus.OK);
			}
		}
		catch (Exception e)
		{
			throw new LoanServiceAlreadyExists("Already Exsist");
			
		}
	}
	
	@PutMapping(value="/approvingLoan{loanId}")
	public ResponseEntity<LoanService> approveLoan(@PathVariable int loanId,@RequestHeader String token)
	{
		try {

			Optional<User> user = iuserservice.findBytoken(token);
			
			if (user.isEmpty()) {
			throw new LoanServiceAlreadyExists("token is incorrect");
			}
			else {
				LoanService newLoanservice = iloanservice.approveLoanService(loanId);
				return new ResponseEntity<LoanService>(newLoanservice, HttpStatus.OK);
			}

		} 
		
		catch ( LoanServiceNotFoundException e) {
			throw new LoanServiceNotFoundException("loanId does'nt exsist");
		}
	}
	
	
	@GetMapping(value="/rejectingLoan{loanId}")
	public ResponseEntity<LoanService> rejectLoan(@PathVariable int loanId, @RequestHeader String token)
	{
	
		try {

			Optional<User> user = iuserservice.findBytoken(token);
			
			if (user.isEmpty()) {
			throw new LoanServiceNotFoundException("token is incorrect");
			}
			else {
				LoanService newLoanservice = iloanservice.rejectLoanService(loanId);
				return new ResponseEntity<LoanService>(newLoanservice, HttpStatus.OK);
			}

		} 
		
		catch ( LoanServiceNotFoundException e) {
			throw new LoanServiceNotFoundException("loanId does'nt exsist");
		}
		
		
	}
	
	
	
	
	

}
