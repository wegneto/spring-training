package com.wegneto.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
}
