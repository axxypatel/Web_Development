package com.neu.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.web.dao.UserDAO;
import com.neu.web.pojo.*;

@Controller
public class LoginUserController {
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	public String userLogin(HttpServletRequest request,HttpSession session, Drug drug, Patient patient) throws Exception {
		System.out.println((String)request.getParameter("username"));
		User u = userDao.checkUser((String)request.getParameter("username"), (String)request.getParameter("password"));
		if(u == null)
		{	
			System.out.println("null user");
			return "login";				
		}
		else
		{
			session.setAttribute("user", u);
			String role = u.getRoleType();
			System.out.println(role);
			if("D".equals(role)) {
				return "searchPatient";
			}
			else if("P".equals(role)) {
				System.out.println("inside pharmacy");
				return "pharmacy";
			}
			else if("R".equals(role)) {
				return "patient";
			}
			else {return "home";}
		}
		
	}
	@RequestMapping(value = "/go-home.htm", method = RequestMethod.POST)
	protected ModelAndView goHomePage(HttpServletRequest request, HttpSession session) throws Exception {	
		return new ModelAndView("login");
	}
//	@RequestMapping(value = "/logout.htm", method = RequestMethod.POST)
//	protected ModelAndView goLogout(HttpServletRequest request, HttpSession session) throws Exception {	
//		session.invalidate();  
//		return new ModelAndView("login");
//	}

}
