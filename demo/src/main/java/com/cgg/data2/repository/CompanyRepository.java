package com.cgg.data2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgg.data2.VO.Employee;

@Repository
public interface CompanyRepository extends JpaRepository<Employee, Integer> {

}
