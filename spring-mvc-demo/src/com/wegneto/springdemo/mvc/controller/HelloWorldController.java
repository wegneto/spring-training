package com.wegneto.springdemo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processForm_v2")
	public String processForm_v2(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		name = name.toUpperCase();
		
		String result = "toUpperCase = " + name;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processForm_v3")
	public String processForm_v3(@RequestParam("studentName") String studentName, Model model) {
		String name = studentName.toUpperCase();
		
		String result = "processForm_v3: " + name;
		
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
