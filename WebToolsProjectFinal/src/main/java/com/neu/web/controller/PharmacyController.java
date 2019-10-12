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
import com.neu.web.validator.DrugValidation;
import com.neu.web.dao.*;

@Controller
public class PharmacyController {
	
	@Autowired
	DrugDAO drugDao;
	
	@Autowired
	@Qualifier("DrugValidation")
	DrugValidation validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/pharmacy.htm", method = RequestMethod.POST)
	public ModelAndView drugAdd(@ModelAttribute("drug")Drug drug,BindingResult result,HttpSession session) throws Exception{
		System.out.println("In Pharma controller");
		//Drug d = null;
		
		validator.validate(drug, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("pharmacy", "drug", drug);
		}
		
		Drug d = drugDao.getDrug(drug.getDrugcomid());
		if(d == null)
		{
			System.out.println("In Drug add");
			drugDao.add(drug);	
			return new ModelAndView("drug-added");
		}
		else
			return new ModelAndView("pharmacy");
		
		
	}

}
