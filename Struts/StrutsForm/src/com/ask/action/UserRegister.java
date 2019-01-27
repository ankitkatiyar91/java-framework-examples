package com.ask.action;

import java.util.ArrayList;
import java.util.Map;

import com.ask.data.Country;
import com.ask.data.RegisterData;
import com.google.code.jcaptcha4struts2.common.actions.JCaptchaBaseAction;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class UserRegister extends JCaptchaBaseAction implements Validateable {
	
	private RegisterData register;
	private ArrayList<Country> country;
	public ArrayList<Country> getCountry() {
		country=new ArrayList<Country>();
		country.add(new Country(1, "India"));
		country.add(new Country(2, "United States"));
		country.add(new Country(3, "Brazil"));
		return country;
	}

	public void setCountry(ArrayList<Country> country) {
		country=new ArrayList<Country>();
		country.add(new Country(1, "India"));
		country.add(new Country(2, "United States"));
		country.add(new Country(3, "Brazil"));
		this.country = country;
	}
	public RegisterData getRegister() {
		return register;
	}

	public void setRegister(RegisterData register) {
		this.register = register;
	}
	@Validations(
			requiredFields={
					@RequiredFieldValidator(type=ValidatorType.FIELD,fieldName="register.gender",message="Select Gender")	
			},
			requiredStrings={
					@RequiredStringValidator (type=ValidatorType.SIMPLE,fieldName="register.firstname",message="Enter a valid First Name"),
					@RequiredStringValidator (type=ValidatorType.SIMPLE,fieldName="register.lastname",message="Enter a valid Last Name"),
					@RequiredStringValidator(type=ValidatorType.SIMPLE,fieldName="register.gender",message="Select Gender"),
					@RequiredStringValidator(type=ValidatorType.SIMPLE,fieldName="register.email",message="Enter your email"),
					@RequiredStringValidator(type=ValidatorType.SIMPLE,fieldName="register.country",message="Select your living place")
			},
			emails={
					@EmailValidator(type=ValidatorType.SIMPLE,fieldName="register.email",message="Enter a valid email")
		
			}
			)
	
	public String execute()
	{
		System.out.println("Registered Successfully====");
		System.out.println("dob--"+register.getDob().toString());
		System.out.println("dob--"+register.getTime().toString());
		return SUCCESS;
	}

}
