package com.neu.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.web.pojo.User;

public class userValidation implements Validator {

	public boolean supports(Class uClass) {
		return uClass.equals(User.class);
	}

	 private Pattern pattern;  
	 private Matcher matcher;  
	
	 private static final   
	 String STRING_PATTERN = "[a-zA-Z]+"; 
	 String STRING_PATTERN2 = "[a-zA-Z0-9-\\.]+";
	 //String STRING_PATTERN3 = "\\(?\\d+\\)?[-.\\s]?\\d+[-.\\s]?\\d+";
	 String STRING_PATTERN3 = "^[789]\\d{9}$";
	
			 
			 
	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		 if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(user.getFirstName());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("firstName", "firstName.containNonChar",  
			      "Enter a valid first name");  
			   }  
			  }  
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		if (!(user.getLastName() != null && user.getLastName().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN);  
			   matcher = pattern.matcher(user.getLastName());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("lastName", "lastName.containNonChar", "Enter a valid last name");  
			   }  
			  } 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
		if (!(user.getUsername() != null && user.getUsername().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN2);  
			   matcher = pattern.matcher(user.getUsername());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("username", "username.containNonChar",  
			      "Enter a valid username");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		if (!(user.getPassword() != null && user.getPassword().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN2);  
			   matcher = pattern.matcher(user.getPassword());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("password", "password.containNonChar",  
			      "Enter a valid password of strings");  
			   }  
			  }
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "error.invalid.mobileNumber", "Mobile Number Required");
		if (!(user.getMobileNumber() != null && user.getMobileNumber().isEmpty())) {  
			   pattern = Pattern.compile(STRING_PATTERN3);  
			   matcher = pattern.matcher(user.getMobileNumber());  
			   if (!matcher.matches()) {  
			    errors.rejectValue("mobileNumber", "mobileNumber.containNonChar",  
			      "Enter a valid password of strings");  
			   }  
			  }
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email.emailAddress", "error.invalid.email.emailAddress",
//				"Email Required");
		 
//		if("NONE".equals(user.get())){
//			errors.rejectValue("usertype", "error.invalid.usertype","User type is required");
//		}
		// check if user exists
		
	}
}