package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	public HomePageController() {
		System.out.println("In Constructor of " + getClass().getName());
	}

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("in show Home Page");
		return "redirect:/customer-login";
	}

}
