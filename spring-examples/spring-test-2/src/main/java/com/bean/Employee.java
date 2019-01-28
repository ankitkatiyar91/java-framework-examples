/**
 * 
 */
package com.bean;


/**
 * @author ipg
 * 
 */

public class Employee {

	public String name;
	private String type;

	public Employee(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
