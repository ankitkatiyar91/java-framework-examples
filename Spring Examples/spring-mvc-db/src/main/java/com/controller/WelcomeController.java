package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("welcome")
public class WelcomeController {
	
	
	@RequestMapping(value="hello",method = RequestMethod.GET)
	public String sayHello(Model model){
		System.out.println("WelcomeController.sayHello() ");
		return "welcome";
	}

	@RequestMapping(value="hello/{name}",method = RequestMethod.GET)
	public ModelAndView sayHelloWithName(ModelAndView model,@PathVariable String name){
		System.out.println("WelcomeController.sayHelloWithName( ) Name->"+name);
		model.setViewName("welcome");
		model.addObject("name", name);
		return model;
	}
}
