package com.neu.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.web.pojo.Patient;

public class PatientValidation implements Validator {

	public boolean supports(Class pClass) {
		return pClass.equals(Patient.class);
	}

	 private Pattern pattern;  
	 private Matcher matcher;  
	
	 private static final 
	 String STRING_PATTERN1 = "[a-zA-Z]+";
	 String STRING_PATTERN2 = "[a-zA-Z0-9-\\.]+";
	 String STRING_PATTERN3 = "[0-9]+";
	 //String ZIP_PATTERN3 = "^[0-9]\\d{5}$";
	 String ZIP_PATTERN3 = "^[0-9]{5}(?:-[0-9]{4})?$";
	 String STRING_PATTERN4 = "^[789]\\d{9}$";
	
			 
			 
	public void validate(Object obj, Errors errors) {
		Patient patient = (Patient) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patientName", "error.invalid.patient", "Patient Name Required");
		 if (!(patient.getPatientName() != null && patient.getPatientName().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN1);  
			   matcher = pattern.matcher(patient.getPatientName());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("patientName", "patientName.containNonChar",  "Enter a valid Patient Name");  
			   }  
			  } 
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patientAge", "error.invalid.patient", "Patient Age Required");
		 if (!(patient.getPatientAge() != null && patient.getPatientAge().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN3);  
			   matcher = pattern.matcher(patient.getPatientAge());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("patientAge", "patientAge.containNonChar",  "Enter a valid Patient Age");  
			   } else if (Integer.parseInt(patient.getPatientAge())>160 || Integer.parseInt(patient.getPatientAge())< 1) {
				   errors.rejectValue("patientAge", "patientAge.containMoreAge",  "Enter a valid Patient Age under 160  years or above 1 year");
			   } 
			  } 
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patientMobile", "error.invalid.patient", "Patient Name Required");
		 if (!(patient.getPatientMobile() != null && patient.getPatientMobile().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN4);  
			   matcher = pattern.matcher(patient.getPatientMobile());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("patientMobile", "patientMobile.containNonChar",  "Enter a valid Patient Mobile");  
			   }  
			  } 
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.patient", "City Required");
		 if (!(patient.getCity() != null && patient.getCity().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN1);  
			   matcher = pattern.matcher(patient.getCity());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("city", "city.containNonChar",  "Enter a valid City Name");  
			   }  
			  }
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipcode", "error.invalid.patient", "Patient Name Required");
		 if (!(patient.getZipcode() != null && patient.getZipcode().isEmpty())) {  
			   pattern = Pattern.compile(ZIP_PATTERN3);  
			   matcher = pattern.matcher(patient.getZipcode());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("zipcode", "zipcode.containNonChar",  "Enter a valid Zip Code");  
			   }  
			  }
		 
		 
		
		
		
	}
}