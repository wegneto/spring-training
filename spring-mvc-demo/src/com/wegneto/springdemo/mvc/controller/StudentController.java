package com.wegneto.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wegneto.springdemo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println("First name: " + student.getFirstName());
		System.out.println("Last name: " + student.getLastName());
		
		return "student-confirmation";
	}
	
}
