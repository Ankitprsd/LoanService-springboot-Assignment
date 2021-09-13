package com.techment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BankService")
public class LoanService {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bankName;
	private float minLoanAmount;
	private float maxLoanAmount;
	private float minInterestRate;
	private float minCreditScore;
	private String termLength;
	private float processingFee;
	private int rating;
	private String Status;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public float getMinLoanAmount() {
		return minLoanAmount;
	}
	public void setMinLoanAmount(float minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	public float getMaxLoanAmount() {
		return maxLoanAmount;
	}
	public void setMaxLoanAmount(float maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	public float getMinInterestRate() {
		return minInterestRate;
	}
	public void setMinInterestRate(float minInterestRate) {
		this.minInterestRate = minInterestRate;
	}
	public float getMinCreditScore() {
		return minCreditScore;
	}
	public void setMinCreditScore(float minCreditScore) {
		this.minCreditScore = minCreditScore;
	}
	public String getTermLength() {
		return termLength;
	}
	public void setTermLength(String termLength) {
		this.termLength = termLength;
	}
	public float getProcessingFee() {
		return processingFee;
	}
	public void setProcessingFee(float processingFee) {
		this.processingFee = processingFee;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public LoanService(int id, String bankName, float minLoanAmount, float maxLoanAmount, float minInterestRate,
			float minCreditScore, String termLength, float processingFee, int rating, String status) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.minLoanAmount = minLoanAmount;
		this.maxLoanAmount = maxLoanAmount;
		this.minInterestRate = minInterestRate;
		this.minCreditScore = minCreditScore;
		this.termLength = termLength;
		this.processingFee = processingFee;
		this.rating = rating;
		Status = status;
	}
	public LoanService() {
		super();
	}
	@Override
	public String toString() {
		return "LoanService [id=" + id + ", bankName=" + bankName + ", minLoanAmount=" + minLoanAmount
				+ ", maxLoanAmount=" + maxLoanAmount + ", minInterestRate=" + minInterestRate + ", minCreditScore="
				+ minCreditScore + ", termLength=" + termLength + ", processingFee=" + processingFee + ", rating="
				+ rating + ", Status=" + Status + "]";
	}
	
	
	
	
	

}
