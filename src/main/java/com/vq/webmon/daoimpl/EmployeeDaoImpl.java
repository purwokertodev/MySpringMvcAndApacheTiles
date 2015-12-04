package com.vq.webmon.daoimpl;

import org.springframework.stereotype.Repository;

import com.vq.webmon.dao.EmployeeDao;
import com.vq.webmon.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee> implements EmployeeDao{
	
	public EmployeeDaoImpl(){
		super(Employee.class);
	}

}
