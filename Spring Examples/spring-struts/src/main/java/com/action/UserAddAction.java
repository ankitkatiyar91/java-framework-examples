package com.action;

import com.bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.persistance.UserUtil;

public class UserAddAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "user.email", message = "Email is required", trim = true),
			@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "user.job", message = "Job Description is required", trim = true),
			@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "user.name", message = "Name is required", trim = true), }, requiredFields = { @RequiredFieldValidator(type = ValidatorType.FIELD, fieldName = "user.dob", message = "Date is required") }, dateRangeFields = { @DateRangeFieldValidator(type = ValidatorType.FIELD, fieldName = "user.dob", shortCircuit = true, message = "Please enter your birthday between ${min} and ${max}", min = "01-01-1990", max = "24-06-2014") }, emails = { @EmailValidator(type = ValidatorType.FIELD, fieldName = "user.email", message = "Enter a valid email") })
	public String add() {
		System.out.println("UserAddAction.add()--" + user);
		try {
			UserUtil.addUser(user);
			System.out.println("Added->" + user);
		} catch (Throwable e) {
			e.printStackTrace();
			addActionError(e.toString());
			return INPUT;
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
