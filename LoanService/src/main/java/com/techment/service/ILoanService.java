package com.techment.service;

import com.techment.entity.LoanService;

public interface ILoanService {
	

	LoanService saveLoanService(LoanService loanservice);
	LoanService approveLoanService(int loanId);
	LoanService rejectLoanService(int loanId);
	
	

}
