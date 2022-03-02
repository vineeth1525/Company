package com.cgg.data2.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cgg.data2.VO.Employee;
import com.cgg.data2.VO.EmployeeDto;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
	
	Employee dtoToVo(EmployeeDto employeeDto);
	EmployeeDto voToDto(Employee employee);
	List<EmployeeDto> toEmployeeListDto(List<Employee> employee);

	List<Employee> fromEmployeeListDto(List<EmployeeDto> employeeDto);
	
}
