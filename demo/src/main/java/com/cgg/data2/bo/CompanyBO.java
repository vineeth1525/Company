package com.cgg.data2.bo;

import java.util.List;

import com.cgg.data2.VO.EmployeeDto;

public interface CompanyBO {
	public List<EmployeeDto> getAllEmployees();
	public List<EmployeeDto> getAllEmployeesUsingFeign();
}
