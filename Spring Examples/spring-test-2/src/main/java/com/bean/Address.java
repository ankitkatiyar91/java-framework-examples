package com.bean;

import java.util.Locale;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class Address implements MessageSourceAware, BeanNameAware,InitializingBean{

	private String street;
	private String city;
	private Integer pinCode;
	private MessageSource messageSource;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public String toString() {
		return messageSource.getMessage("address", new Object[]{street,city,pinCode}, Locale.FRENCH);
	}
	
	public void destroy(){
		System.err.println("Address Bean for name "+beanName+" is destroying ");
	}

	public void setBeanName(String name) {
		System.err.println("Address class bean name initialized "+name);
		this.beanName=name;
	}

	private String beanName;

	public void afterPropertiesSet() throws Exception {
		System.err.println("Address Initializing bean for name "+beanName);
		
	}
	
	public void init(){
		System.err.println("Address Bean for name "+beanName+" is init ");
	}
}
