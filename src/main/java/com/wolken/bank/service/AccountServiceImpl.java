package com.wolken.bank.service;

import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.bank.dto.AccountDTO;

import com.wolken.bank.entity.AcountEntity;

import com.wolken.bank.repository.AccountRepo;


	@Service
	public class AccountServiceImpl implements AccountService {
		@Autowired
		AccountRepo repo;
		
		private Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);
		@Override
		public String validateAndCreate(AccountDTO dto) {
			try {
				if(dto!=null)
				{
					logger.info(""+dto);
					AcountEntity entity=new AcountEntity();
					BeanUtils.copyProperties(dto, entity);
					logger.info(""+entity);
					repo.save(entity);
					logger.info("Account Created !!");
					return "Account Created Successfully!!";
				}
				
			}catch(NullPointerException | TypeMismatchException e)
			{
			  logger.error(e.getMessage(),e.getClass().getSimpleName());
			}
			return null;
		
		}
		@Override
		public double validateAndgetCurrentBalance(String holderName) {
			// TODO Auto-generated method stub
			try {
				if(holderName!=null)
				{
					logger.info(holderName);
					double entity=(double) repo.getCurrentBalance(holderName);
					
					logger.info(""+entity);
					
					return entity;
				}
				
			}catch(Exception e)
			{logger.error("========you have an exception in EmployeeController.getName=====");
			  logger.error(e.getMessage(),e.getClass());
			}
			
			return 0;
		}
		
		public AccountDTO validateAndFindByBranchName(String branchName) {
			// TODO Auto-generated method stub
			try {
				if(branchName!=null)
				{
					logger.info(branchName);
					AcountEntity entity=repo.findByBranchName(branchName);
					
					logger.info(""+entity);
					if(entity!=null) {
						AccountDTO dto=new AccountDTO();
						BeanUtils.copyProperties(entity,dto);
						logger.info(""+dto);
					
					return dto;
				}
				
			} else {
				logger.info("invalid name");
						return null;
						
			}
			}
				catch(Exception e)
			{logger.error("========you have an exception in EmployeeController.getName=====");
			  logger.error(e.getMessage(),e.getClass());
			}
			
			return null;
		}
		
		@Override
		public String validateAndDeposit(AccountDTO dto) {
			// TODO Auto-generated method stub
			
			logger.info("dto"+dto);
			
			AcountEntity entity = new AcountEntity();
			logger.info("dto"+dto);
			if(dto!=null) {
			entity=repo.getByAccountNo(dto.getAccountNo());
			logger.info(""+entity);
			float total=repo.getByAccountNo(dto.getAccountNo()).getAmount()+dto.getAmount();
			if(total>0) {
			entity.setAmount(total);
			logger.info(""+entity.getAmount());
			repo.save(entity);
			return "Amount deposited";}
			else {
				logger.error("Enter valid amount");
			}
			}
			
		
			return null;
		}
		@Override
		public String validateAndWithdraw(AccountDTO dto) {
			// TODO Auto-generated method stub
			
				logger.info(""+repo.getByAccountNo((long)2));
				logger.info(""+dto);
				AcountEntity entity = new AcountEntity();
				if(dto!=null) {
				entity=repo.getByAccountNo(dto.getAccountNo());
				logger.info(""+entity);
				float total=repo.getByAccountNo(dto.getAccountNo()).getAmount()-dto.getAmount();
				if(total>0) {
				entity.setAmount(total);
				logger.info(""+entity.getAmount());
				repo.save(entity);
				return "amount Withdrawn";}
				else {
					logger.error("Enter valid amount");
				}
				}
				else {
					return null;
				}
				return null;
		}
		
		@Override
		public String validateAccountStatus(AccountDTO dto) {
			// TODO Auto-generated method stub
			logger.info(""+repo.getByAccountNo((long)2));
			logger.info(""+dto);
			AcountEntity entity = new AcountEntity();
			if(dto!=null) {
			entity=repo.getByAccountNo(dto.getAccountNo());
			logger.info(""+entity);
			String total=dto.getStatus();
			
			entity.setStatus(total);
			logger.info(""+entity.getAmount());
			repo.save(entity);
			return "Account Closed";}
			else {
				logger.error("Enter valid amount");
			}
			
			
			return null;
			
		}
		
	
	}
		
		
	
		
		

	