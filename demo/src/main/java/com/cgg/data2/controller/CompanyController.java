package com.cgg.data2.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cgg.data2.VO.Employee;
import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.client.EmployeeClient;
import com.cgg.data2.config.RestEnvConfig;
import com.cgg.data2.exception.ServiceException;
import com.cgg.data2.service.CompanyService;
import com.cgg.data2.utils.CommonContants;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@ValidateOnExecution
@RequestMapping("company")

public class CompanyController {

	@Autowired
	RestEnvConfig restEnvConfig;
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
	public ResponseEntity<List<Employee>>  getAllEmployees() {
//		EmployeeDto[] emp = 
//				restTemplate.getForObject(restEnvConfig.getConfigEnv(), EmployeeDto[].class);

		List<Employee> allEmployees = companyService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
	}
	public ResponseEntity<String>  getAllEmployeesFallback(Exception e){
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Service down");
		//Stream.of(
//		new Employee("elon",2,"eee",25000),
//		new Employee("musk",2,"eee",25000),
//		new Employee("mars",2,"eee",25000)
//
//		).collect(Collectors.toList());
		}


	
	@GetMapping("/getAllEmployees-feign")

	public List<EmployeeDto> getAllEmployeesUsingFeign() throws ServiceException {
		return employeeClient.getEmployeeList();
	}
}
