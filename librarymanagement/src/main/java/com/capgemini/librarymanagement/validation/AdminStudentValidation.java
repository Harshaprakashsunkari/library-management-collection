package com.capgemini.librarymanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagement.exception.ValidationException;

public class AdminStudentValidation {
	
	public boolean validateId(int id) throws ValidationException {
		String idReg = "[1-9] {1}[0-9] {2}";
		boolean result = false;
		if(Pattern.matches(idReg, String.valueOf(id))) {
			result = true;
		}else {
			throw new ValidationException("Id should contain 3 digits");
		}
		return result;
	}
	
	public boolean validateName(String name) throws ValidationException {
		String nameReg = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(nameReg);
		Matcher matcher = pattern.matcher(name);
		if(matcher.matches()) {
			result = true;
		}else {
			throw new ValidationException("Name should contain only alphabets");
		}
		return result;
	}
	
	public boolean validateMobile(String mobile) throws ValidationException {
		String mobileReg = "(0/91)?[6-9][0-9]{9}";
		boolean result = false;
		Pattern pattern = Pattern.compile(mobileReg);
		Matcher matcher = pattern.matcher(mobile);
		if(matcher.matches()) {
			result = true;
		}else {
			throw new ValidationException("Mobile number should start with 6 to 9 and it should contain 10 digits");
		}
		return result;		
	}
	
	public boolean validatePassword(String password) throws ValidationException {
		String passwordReg = "((?=.[a-z])(?=.\\d)(?=.[A-Z])(?=.[@#$%!]).{8,40})" ;
		boolean result = false;
		if(Pattern.matches(passwordReg, String.valueOf(password))) {
			result = true;
		}else {
			throw new ValidationException("Password should contain atleast 8 characters. Also it should contain one uppercase,one lowercase,one character");
		}
		return result;
	}
	
	public boolean validateDate(String date) throws ValidationException {
		String dateReg = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		boolean result = false;
		Pattern pattern = Pattern.compile(dateReg);
		Matcher matcher = pattern.matcher((CharSequence)date);
		if(matcher.matches()) {
			result = true;
		}else {
			throw new ValidationException("Enter proper Date Format");
		}
		return result;
	}
	
	public boolean validateBookId(int id) throws ValidationException {
		String idReg = "[1-9] {1}[0-9] {3}";
		boolean result = false;
		if(Pattern.matches(idReg, String.valueOf(id))) {
			result = true;
		}else {
			throw new ValidationException("Id should contains exactly 4  digits");
		}
		return result;
	}
}
