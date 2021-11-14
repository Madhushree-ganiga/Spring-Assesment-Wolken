package com.wolken.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.entity.EmployeeEntity;
import com.wolken.bank.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
 
	
	@Autowired
	EmployeeRepo repo;
	private Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Override
	public List<EmployeeDTO> validateAndGetAll() {
		// TODO Auto-generated method stub
		List<EmployeeDTO> dtos = new ArrayList<>();
		List<EmployeeEntity> list = repo.findAll();
		logger.info("list"+list.toString());
		for(EmployeeEntity employeeEntity : list) {
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, dto);
			dtos.add(dto);
			logger.info("dto", dto);
		}
		
		
		
		
		return dtos;
	}
	@Override
	public String validateAndSave(EmployeeDTO dto) {
		// TODO Auto-generated method stub
		try {
			if(dto!=null) {
				logger.info(""+dto);
				EmployeeEntity entity=new EmployeeEntity();
				BeanUtils.copyProperties(dto, entity);
				logger.info(""+entity);
				repo.save(entity);
				logger.info("Data saved");
				return "Data Saved";
			}
			else
			{
				logger.info("Object Is Null");
	return "Data Not Saved";
	}
		
		}
		catch( NullPointerException | TypeMismatchException e)
		{logger.error(e.getMessage(),e.getClass().getSimpleName());
		
		}
		return null;
	}
	@Override
	public EmployeeDTO validateAndFindByName(String name) {
		// TODO Auto-generated method stub
		try {
			if(name!=null) {
				logger.info(name);
				EmployeeEntity entity=repo.findByName(name);
				logger.info(""+entity);
				if(entity!=null) {
					EmployeeDTO dto=new EmployeeDTO();
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}
			}
			else {
				logger.info("invalid name");
				return null;
			}
		}
		catch(Exception e) {
			logger.error("========you have an exception in EmployeeController.getByName() ===");
			logger.error(e.getMessage(),e.getClass());

		}
		return null;
			
		}
	
	@Override
	public EmployeeDTO validateAndFindAll() {
		// TODO Auto-generated method stub
		try {
			
				List<EmployeeEntity> entity=repo.findAll();
				logger.info(""+entity);
				if(entity!=null) {
					EmployeeDTO dto=new EmployeeDTO();
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}
			
			
		}
		catch(Exception e) {
			logger.error("========you have an exception in EmployeeController.getByName() ===");
			logger.error(e.getMessage(),e.getClass());

		}
		return null;
			
		}
	@Override
	public EmployeeDTO validateAndFindByDesignation(String designation) {
		// TODO Auto-generated method stub
		try {
			if(designation!=null) {
				logger.info(designation);
				EmployeeEntity entity=repo.findByDesignation(designation);
				logger.info(""+entity);
				if(entity!=null) {
					EmployeeDTO dto=new EmployeeDTO();
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}
			}
			else {
				logger.info("invalid designation");
				return null;
			}
		}
		catch(Exception e) {
			logger.error("========you have an exception in EmployeeController.getByName() ===");
			logger.error(e.getMessage(),e.getClass());

		}
		return null;
			
		}
	@Override
	public EmployeeDTO validateAndFindBySalary(float salary) {
		// TODO Auto-generated method stub
		try {
			
				EmployeeEntity entity=repo.findBySalary(salary);
				logger.info(""+entity);
				if(entity!=null) {
					EmployeeDTO dto=new EmployeeDTO();
					BeanUtils.copyProperties(entity,dto);
					return dto;
				}
			
			else {
				logger.info("salary not found");
				return null;
			}
		}
		catch(Exception e) {
			logger.error("========you have an exception in EmployeeController.getByName() ===");
			logger.error(e.getMessage(),e.getClass());

		}
		
		return null;
	}
			}
			