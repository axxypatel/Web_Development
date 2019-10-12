package com.neu.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.web.pojo.Drug;

public class DrugValidation implements Validator {

	public boolean supports(Class dClass) {
		return dClass.equals(Drug.class);
	}

	 private Pattern pattern;  
	 private Matcher matcher;  
	
	 private static final   
	 String STRING_PATTERN2 = "[a-zA-Z]+";
	 String STRING_PATTERN3 = "[0-9]+";
	 //String ZIP_PATTERN3 = "^[0-9]\\d{5}$";
	
			 
			 
	public void validate(Object obj, Errors errors) {
		Drug drug = (Drug) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drugcomid", "error.invalid.drug", "Drug ID Required");
		 if (!(drug.getDrugcomid() != null && drug.getDrugcomid().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN3);  
			   matcher = pattern.matcher(drug.getDrugcomid());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("drugcomid", "drugcomid.containNonChar",  "Enter a valid Drug ID");  
			   }  
			  }  
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drugName", "error.invalid.drug", "Drug Name Required");
		if (!(drug.getDrugName() != null && drug.getDrugName().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN2);  
			   matcher = pattern.matcher(drug.getDrugName());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("drugName", "drugName.containNonChar",  "Enter a valid Drug name");  
			   }  
			  } 
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dosageValue", "error.invalid.drug", "Drug Dosage Required");
		if (!(drug.getDosageValue() != null && drug.getDosageValue().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN3);  
			   matcher = pattern.matcher(drug.getDosageValue());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("dosageValue", "dosageValue.containNonChar",  "Enter a valid Drug dosage");  
			   }  
			  } 
		
		
	}
}