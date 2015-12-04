package com.vq.webmon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vq.webmon.domain.Employee;
import com.vq.webmon.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView employeeList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee_list");
		List<Employee> list = employeeService.findAll();
		mav.addObject("emList", list);
		return mav;
	}
	

	@RequestMapping("/employees")
	public @ResponseBody List<Employee> getEmployees(){
		List<Employee> list = employeeService.findAll();
		return list;
	}
	
}
