package com.ask.data;

import java.sql.Time;
import java.util.Date;

public class RegisterData {
	
	private String firstname,lastname,middlename,email,country,gender,state,time;
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private Date dob;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
