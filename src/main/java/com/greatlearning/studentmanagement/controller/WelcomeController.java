package com.greatlearning.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String showHomepage() {
		return "home";
	}

}
