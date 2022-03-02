package com.cgg.data2.eo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.client.RestTemplates;

@Component
public class CompanyEOImpl implements CompanyEO {

	@Autowired
	RestTemplates restTemplates;
	
	public CompanyEOImpl() {
		
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		
		return restTemplates.getAllEmployees() ;
	}

	@Override
	public List<EmployeeDto> getAllEmployeesUsingFeign() {
		return null;
	}

}
