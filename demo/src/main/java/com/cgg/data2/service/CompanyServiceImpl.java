package com.cgg.data2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgg.data2.VO.Employee;
import com.cgg.data2.bo.CompanyBO;
import com.cgg.data2.mapper.EmployeeMapper;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	CompanyBO companyBO;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> emp = employeeMapper.fromEmployeeListDto(companyBO.getAllEmployees());
		return emp;
	}

	@Override
	public List<Employee> getAllEmployeesUsingFeign() {
		return null;
	}

	

	
	}


