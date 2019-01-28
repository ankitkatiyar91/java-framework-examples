/**
 * 
 */
package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ipg
 * 
 */
@Controller
@RequestMapping("/welcome")
public class MyController {

	@RequestMapping(value="/message", method = RequestMethod.GET)
	public String showMessage(ModelMap map) {
		System.out.println("WelcomeController.showMessage()");
		map.addAttribute("message", "Hello my message");
		return "welcome";
	}
}
