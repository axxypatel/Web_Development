package com.neu.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.web.pojo.*;


@Controller
public class MainPageController {
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request, ModelMap model) {
		//command object
		//model.addAttribute("applicant", applicant);
		request.setAttribute("action", "save");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, ModelMap model, User user) {
		
		return new ModelAndView("register");
	}
}
