package com.techment.service;

import java.util.NoSuchElementException;

import org.hibernate.engine.internal.SessionEventListenerManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.techment.entity.LoanService;
import com.techment.exception.LoanServiceAlreadyExists;
import com.techment.exception.LoanServiceNotFoundException;
import com.techment.repository.LoanServiceRepository;
import com.techment.util.SiteUtil;


@Service
public class LoanServiceImpl implements ILoanService{
	
	
	@Autowired
	LoanServiceRepository loanServiceRepository;
	

	@Override
	public LoanService saveLoanService(LoanService loanservice) throws LoanServiceAlreadyExists {
//		LoanService service = new LoanService();
//		service.setId(loanservice.getId());
//		service.setBankName(loanservice.getBankName());
//		service.setMaxLoanAmount(loanservice.getMaxLoanAmount());
//		service.setMinLoanAmount(loanservice.getMinLoanAmount());
//		service.setMinInterestRate(loanservice.getMinInterestRate());
//		service.setMinCreditScore(loanservice.getMinCreditScore());
//		service.setStatus(loanservice.getStatus());
//		service.setRating(loanservice.getRating());
//		return service;

		LoanService service = loanServiceRepository.save(loanservice);
		return service;

	}

	@Override
	public LoanService approveLoanService(int loanId) throws LoanServiceNotFoundException {
//	
		LoanService loanApplication = loanServiceRepository.findById(loanId).get();
		loanApplication.setStatus("Accepted");
        loanServiceRepository.save(loanApplication);
		//LoanService  loan = new LoanService(loanApplication.getId(),loanApplication.getBankName(),loanApplication.getMaxLoanAmount(),loanApplication.getMinCreditScore(),loanApplication.getMinInterestRate(),loanApplication.getMinLoanAmount(),loanApplication.getProcessingFee(),loanApplication.getRating(),loanApplication.getTermLength());
		return loanApplication;
	
	}

	@Override
	public LoanService rejectLoanService(int loanId) throws LoanServiceNotFoundException{
		
		LoanService loanApplication1 = loanServiceRepository.findById(loanId).get();
//		loanApplication1.setMinCreditScore(750);
//		loanApplication1.setMinLoanAmount(90000);
		loanApplication1.setStatus("Rejected");
		loanServiceRepository.save(loanApplication1);
//		if(loanApplication1.getMinCreditScore() < 740.0)
//			return loanApplication1;
		return loanApplication1;
		
	}
	
	

}
