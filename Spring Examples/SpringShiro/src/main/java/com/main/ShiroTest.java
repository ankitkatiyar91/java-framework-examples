package com.main;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShiroTest {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		
		
		org.apache.shiro.subject.Subject subject=SecurityUtils.getSubject();
		AuthenticationToken token=new UsernamePasswordToken("username", "password");
		System.out.println("Login a user--");
 		subject.login(token);
 		System.out.println("User logged in---");
 		subject.logout();
 		System.out.println("User logged out");
 		
	}

}
