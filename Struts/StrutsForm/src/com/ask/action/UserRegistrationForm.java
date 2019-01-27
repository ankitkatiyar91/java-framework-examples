package com.ask.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ask.data.Country;
import com.opensymphony.xwork2.ActionSupport;

public class UserRegistrationForm extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Country> country;
	public ArrayList<Country> getCountry() {
		return country;
	}

	public void setCountry(ArrayList<Country> country) {
		country=new ArrayList<Country>();
		country.add(new Country(1, "India"));
		country.add(new Country(2, "United States"));
		country.add(new Country(3, "Brazil"));
		this.country = country;
	}
	public String execute()
	{
		setCountry(this.country);
		return SUCCESS;
	}

}
