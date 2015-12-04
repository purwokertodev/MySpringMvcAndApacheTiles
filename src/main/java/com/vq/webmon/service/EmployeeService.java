package com.vq.webmon.service;

import java.util.List;

import com.vq.webmon.domain.Employee;

public interface EmployeeService {
	
	void save(Employee e);
	void update(Employee e);
	void delete(Integer id);
	Employee findOne(Integer id);
	List<Employee> findAll();

}
