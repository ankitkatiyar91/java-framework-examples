package com.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bean.User;

@Controller
@RequestMapping("/form")
public class FormController {

	@RequestMapping("/showForm")
	public ModelAndView showForm() {
		System.out.println("FormController.showForm()");
		ModelAndView view = new ModelAndView("/form/form");
		view.addObject("user", new User());
		return view;

	}

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public ModelAndView sayHello(ModelAndView model, @RequestParam String name,
			Object command) {
		System.out.println("FormController.sayHello() " + command);
		model.addObject("name", name);
		model.setViewName("form/form");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, ModelAndView model,
			@Valid @ModelAttribute User user, BindingResult bindingResult) {
		System.out.println("FormController.addUser() " + user
				+ " bindingResult-->" + bindingResult.hasErrors());
		model.addObject("user", user);
		if (bindingResult.hasErrors()) {
			model.setViewName("/form/form");
			// bindingResult.addAllErrors(bindingResult);
			System.out.println("Validated->");
			/*
			 * Print All the errors for (ObjectError error :
			 * bindingResult.getAllErrors()) { System.out.println("-" + error);
			 * }
			 */
		} else {
			new RedirectView("/form/userDetails");
			request.getSession().setAttribute("user", user);
			model.setView(new RedirectView("userDetails"));
		}
		return model;
	}

	@RequestMapping("/userDetails")
	public ModelAndView showDetails(ModelAndView view,
			HttpServletRequest request) {
		ModelMap map = view.getModelMap();
		view.setViewName("/form/userdetails");
		view.addObject("user", request.getSession().getAttribute("user"));
		request.getSession().removeAttribute("user");
		System.out.println("User->" + map.containsKey("user"));
		return view;
	}

	@InitBinder
	public void bilder(WebDataBinder binder) {
		System.out.println("FormController.bilder()");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				dateFormat, false));
	}

}
