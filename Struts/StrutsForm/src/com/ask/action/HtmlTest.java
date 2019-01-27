package com.ask.action;

import com.opensymphony.xwork2.ActionSupport;

public class HtmlTest extends ActionSupport {
	
	private String ank;

	public String getAnk() {
		return ank;
	}

	public void setAnk(String ank) {
		this.ank = ank;
	}
	
	public void validate()
	{
		System.out.println("HtmlTest.validate()");
		addFieldError("ank", "error hehehhe");
	}
	public String execute()
	{
		System.out.println("HtmlTest.execute()");
		return "success";
	}

}
