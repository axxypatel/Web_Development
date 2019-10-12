package com.neu.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.web.pojo.*;
import com.neu.web.validator.userValidation;
import com.neu.web.dao.*;

@Controller
public class RegisterUserController {
	@Autowired
	UserDAO userDao;
	
	@Autowired
	@Qualifier("userValidator")
	userValidation validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/registerUser.htm", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute("user")User user,BindingResult result,HttpSession session) throws Exception{
		
		validator.validate(user, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("register", "user", user);
		}
		
		User u = userDao.getUser(user.getUsername());
		if(u == null)
		{
			userDao.add(user);
			return new ModelAndView("user-added");
			
		}
		else
		{
			return new ModelAndView("register");
		}
		
	}
	

}
