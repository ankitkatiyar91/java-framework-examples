package com.ask.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ask.data.LoginData;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class UserLogin extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	private LoginData login;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public HttpServletRequest getRequest()
	{
		return this.request;
	}

	public LoginData getLogin() {
		return login;
	}

	public void setLogin(LoginData login) {
		this.login = login;
	}

	@Validations(
			requiredStrings={
				@RequiredStringValidator(type=ValidatorType.SIMPLE,fieldName="login.username",trim=true,message="Enter Username"),
				@RequiredStringValidator(type=ValidatorType.SIMPLE,fieldName="login.password",message="Enter Password")
			}
			)
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		String username=login.getUsername().trim();
		String password=login.getPassword();
		
	}
	
	public String execute()
	{
		System.out.println("username--"+login.getUsername());
		System.out.println("password--"+login.getPassword());
		System.out.println("remenber--"+login.isRemember());
		loginUser();
		return SUCCESS;
	}
	
	public boolean loginUser()
	{
		boolean l=false;
		if(login.isRemember())
		{
			Cookie c=new Cookie("ank", login.getUsername());
			response.addCookie(c);
			System.out.println("cookie set");
			l=true;
		}else {
			Cookie c=new Cookie("ank", "");
			response.addCookie(c);
			}
		
		return l;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	

}
