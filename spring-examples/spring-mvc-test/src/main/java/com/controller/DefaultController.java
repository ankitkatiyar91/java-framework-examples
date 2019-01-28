package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DefaultController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String show(){
		System.out.println("DefaultController.show()");
		return "index";
	}

}
