package com.bean;

import org.springframework.beans.factory.annotation.Required;

public class Person {

	private String name;
	private PersonType type;
	private Integer salary;
	private Address address;

	
	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public PersonType getType() {
		return type;
	}

	public void setType(PersonType type) {
		this.type = type;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", type=" + type + ", salary=" + salary
				+ ", address=" + address + "]";
	}

}
