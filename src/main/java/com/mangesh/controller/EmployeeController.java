package com.mangesh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mangesh.model.Employee;
import com.mangesh.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService iEmployeeService;

	@GetMapping("/index")
	public String indexPage() {
		log.info("Employee Page Registration page Loaded");
		return "employeeRegister";
	}

	@PostMapping("/save")
	public String putEmployeeData(@ModelAttribute Employee employee, Model model) {
		log.info("Employee putEmployeeData method execution started");
		Integer storeEmployeeId = iEmployeeService.storeEmployee(employee);
		String message = "Employee Registration SucessFully With Id " + storeEmployeeId;
		model.addAttribute("message", message);
		log.info("Employee putEmployeeData method execution Ended");
		return "employeeRegister";
	}
}
