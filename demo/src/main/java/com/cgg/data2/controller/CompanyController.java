package com.cgg.data2.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.client.EmployeeClient;
import com.cgg.data2.exception.ServiceException;
import com.cgg.data2.service.CompanyService;
import com.cgg.data2.utils.CommonContants;

@RestController
@ValidateOnExecution
@RequestMapping("company")

public class CompanyController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EmployeeClient employeeClient;

	@Autowired
	CompanyService companyService;
//@Value("${url}")
//public static String url;

	@GetMapping("/get")
	
	public List<EmployeeDto> getAllEmployees() {
		EmployeeDto[] emp = 
				restTemplate.getForObject(CommonContants.RESTTEMPLATE_URL, EmployeeDto[].class);

		return Arrays.asList(emp);
	}

	@GetMapping("/getAllEmployees-feign")

	public List<EmployeeDto> getAllEmployeesUsingFeign() throws ServiceException {
		return employeeClient.getEmployeeList();
	}
}