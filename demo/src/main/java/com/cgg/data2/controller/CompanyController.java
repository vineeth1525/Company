package com.cgg.data2.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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

	public static final String COMPANY_SERVICE ="companyService";
	@GetMapping("/get")
	
	@CircuitBreaker(name ="COMPANY_SERVICE",fallbackMethod = "getAllEmployeesFallback")
	public List<EmployeeDto> getAllEmployees() {
		System.out.println("hi from sub");
		System.out.println("hey from second branch");
		EmployeeDto[] emp = 
				restTemplate.getForObject(CommonContants.RESTTEMPLATE_URL, EmployeeDto[].class);

		return Arrays.asList(emp);
	}
	public List<EmployeeDto> getAllEmployeesFallback(Exception e){
		return Stream.of(
		new EmployeeDto("hey","hello",2500,2),
		new EmployeeDto("hey","hello",2500,2),
		new EmployeeDto("hey","hello",2500,2),		
		new EmployeeDto("hey","hello",2500,2)

		).collect(Collectors.toList());
		}


	
	@GetMapping("/getAllEmployees-feign")

	public List<EmployeeDto> getAllEmployeesUsingFeign() throws ServiceException {
		return employeeClient.getEmployeeList();
	}
}
