package com.cgg.data2.eo;

import java.util.List;

import com.cgg.data2.VO.EmployeeDto;

public interface CompanyEO {

	public List<EmployeeDto> getAllEmployees();
	public List<EmployeeDto> getAllEmployeesUsingFeign();
}
