package com.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document
@Component
public class Address {

	private String id;
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Address(String address) {
		super();
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}

	public Address() {
		super();
	}

}
