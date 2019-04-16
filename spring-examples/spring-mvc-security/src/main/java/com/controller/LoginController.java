package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = { "/", "" }, method = { RequestMethod.GET})
	public String login(HttpServletRequest request) {
		System.out.println("LoginController.login() "+request.getRequestURI());
		return "login";
	}

}
