package com.vq.webmon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.vq.webmon.domain.Employee;
import com.vq.webmon.service.EmployeeService;


@Controller
public class PageController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/adminpage",method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("home");
		List<Employee> list = employeeService.findAll();
		
		Gson gson = new Gson();
		String emGson = gson.toJson(list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emGson", emGson);
		map.put("emList", list);
		mav.addAllObjects(map);
		
		System.out.println(emGson);
		System.out.println(list.toString());
		
		return mav;
	}
	
	@RequestMapping(value = "/employee_multi_line",method = RequestMethod.GET)
	public ModelAndView employeeMultiLine(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("employee_multi_line");
		List<Employee> list = employeeService.findAll();
		mav.addObject("emList", list);
		return mav;
	}
	
	@RequestMapping(value = "/cpu_example", method = RequestMethod.GET)
	public String cpuExample(){
		return "cpu_example";
	}
	
	@RequestMapping("/memory")
	public @ResponseBody Long getMemory(){
		return 90L;
	}
	

}
