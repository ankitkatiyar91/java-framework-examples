package com.action;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;

	public String sayHello() {
		System.out.println("HomeAction.sayHello() "+sessionFactory);
		
		return SUCCESS;
	}

}
