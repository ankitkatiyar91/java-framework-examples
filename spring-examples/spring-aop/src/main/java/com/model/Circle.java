package com.model;

import com.annotation.Loggable;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String name) {
		this.name = name;
		//throw new RuntimeException("Big deal");
	}
	
	public String setNameAndReturn(String name) {
		System.out.println("Circle return setter called "+name);
		return this.name = name+" Setted";
	}

}