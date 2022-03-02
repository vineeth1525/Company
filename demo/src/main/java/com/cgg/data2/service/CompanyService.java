package com.cgg.data2.service;

import java.util.List;

import com.cgg.data2.VO.Employee;

public interface CompanyService {

	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployeesUsingFeign();
}
