package com.wolken.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wolken.bank.entity.AcountEntity;
public interface AccountRepo extends JpaRepository <AcountEntity,Integer> {

	@Query(value="select amount from AcountEntity where holderName=?1")
	double getCurrentBalance(String holderName);
    AcountEntity findByBranchName(String branchName);
	AcountEntity getByAccountNo(long accountNo);
    
	


	



}
