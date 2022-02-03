package com.cgg.data2.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.cgg.data2.VO.EmployeeDto;
import com.cgg.data2.exception.ServiceException;


@FeignClient(url="http://localhost:8080/",name="EMPLOYEE-CLIENT")
public interface EmployeeClient {
	
	@GetMapping("employee/getAllEmployee")
	public ResponseEntity<List<EmployeeDto>> getEmployeeList() throws ServiceException;

}
