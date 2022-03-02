package com.cgg.data2.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.config.RestEnvConfig;



@Component
public class RestTemplates {

	public RestTemplates() {
	}
@Autowired
RestTemplate restTemplate;

@Autowired
RestEnvConfig restEnvConfig;

	public List<EmployeeDto> getAllEmployees() {
		EmployeeDto[] emp = 
				restTemplate.getForObject( "http://localhost:8080/employee/getAllEmployee", EmployeeDto[].class);

		return Arrays.asList(emp);
}
}