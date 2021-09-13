package com.techment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techment.entity.LoanService;


@Repository
public interface LoanServiceRepository extends JpaRepository<LoanService, Integer> {
	
	

}
