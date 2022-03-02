package com.cgg.data2.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.eo.CompanyEO;

@Component
public class CompanyBOImpl implements CompanyBO {

	
	@Autowired
	CompanyEO companyEO;
	public CompanyBOImpl() {
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		return companyEO.getAllEmployees();
	}

	@Override
	public List<EmployeeDto> getAllEmployeesUsingFeign() {
		return null;
	}

}
