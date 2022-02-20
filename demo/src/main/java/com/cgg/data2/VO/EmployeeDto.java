package com.cgg.data2.VO;

import com.cgg.data2.VO.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
private String employeeName;
private String dept;
private long salary;
private int id;


}
