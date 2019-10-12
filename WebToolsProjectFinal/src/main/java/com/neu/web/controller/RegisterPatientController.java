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

import com.neu.web.dao.PatientDAO;
import com.neu.web.pojo.Patient;
import com.neu.web.validator.PatientValidation;

@Controller
public class RegisterPatientController {
	
	@Autowired
	PatientDAO patientDao;
	
	@Autowired
	@Qualifier("PatientValidation")
	PatientValidation validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/patient.htm", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute("patient")Patient patient,BindingResult result,HttpSession session) throws Exception{

		validator.validate(patient, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("patient", "patient", patient);
		}
		
		Patient p = patientDao.getPatient(patient.getPatientMobile());
		if(p == null)
		{
			patientDao.add(patient);
			return new ModelAndView("patient-added");
			
		}
		else
		{
			return new ModelAndView("patient");
		}
		
	}

}
