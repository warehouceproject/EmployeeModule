package com.mangesh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mangesh.controller.EmployeeController;
import com.mangesh.model.Employee;
import com.mangesh.repo.IEmployeeRepository;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {

	private static final Logger log=LoggerFactory.getLogger(IEmployeeServiceImpl.class);
	
	@Autowired
	private IEmployeeRepository iEmployeeRepository;

	@Override
	public Integer storeEmployee(Employee employee) {
		log.info("storeEmployee method executed");
		return iEmployeeRepository.save(employee).getEmpId();
	}
}
