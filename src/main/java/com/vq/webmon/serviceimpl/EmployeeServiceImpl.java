package com.vq.webmon.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vq.webmon.dao.EmployeeDao;
import com.vq.webmon.domain.Employee;
import com.vq.webmon.service.EmployeeService;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao dao;

	@Transactional
	@Override
	public void save(Employee e) {
		dao.save(e);
	}

	@Transactional
	@Override
	public void update(Employee e) {
		dao.update(e);
	}

	@Transactional
	@Override
	public void delete(Integer Id) {
		Employee e = findOne(Id);
		dao.delete(e);
	}

	@Transactional(readOnly = true)
	@Override
	public Employee findOne(Integer id) {
		return dao.findOne(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}

}
