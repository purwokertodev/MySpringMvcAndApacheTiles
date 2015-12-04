package com.vq.webmon.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

@Controller
public class ErrorCustomController {

	@RequestMapping("/error")
	public String customError(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		// retrieve some useful information from the request
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		Throwable throwable = (Throwable) request
				.getAttribute("javax.servlet.error.exception");
		// String servletName = (String)
		// request.getAttribute("javax.servlet.error.servlet_name");
		String exceptionMessage = getExceptionMessage(throwable, statusCode);

		String requestUri = (String) request
				.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}

		String message = MessageFormat.format(
				"{0} returned for {1} with message {3}", statusCode,
				requestUri, exceptionMessage);

		model.addAttribute("errorMessage", message);
		return "customError";
	}

	private String getExceptionMessage(Throwable throwable, Integer statusCode) {
		if (throwable != null) {
			return Throwables.getRootCause(throwable).getMessage();
		}
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		return httpStatus.getReasonPhrase();
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView error403(){
		ModelAndView mav = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(! (auth instanceof AnonymousAuthenticationToken)){
			UserDetails details = (UserDetails) auth.getPrincipal();
			mav.addObject("username", details.getUsername());
		}
		mav.setViewName("error403");
		return mav;
	}
}
