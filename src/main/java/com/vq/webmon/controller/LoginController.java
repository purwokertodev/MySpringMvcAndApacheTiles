package com.vq.webmon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/loginfail", method = RequestMethod.GET)
	public ModelAndView loginFail(RedirectAttributes attribute){
		attribute.addFlashAttribute("success", false);
		return new ModelAndView("redirect:login");
	}

}
