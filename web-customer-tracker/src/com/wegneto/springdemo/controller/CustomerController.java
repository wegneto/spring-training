package com.wegneto.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wegneto.springdemo.entity.Customer;
import com.wegneto.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from the service
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("customerName") String customerName, Model model) {
		// get customers from the service
		List<Customer> customers = customerService.searchCustomer(customerName);

		// add the customers to the model
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForAdd(@RequestParam("customerId") int customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);

		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String showFormForAdd(@RequestParam("customerId") int customerId) {
		customerService.delete(customerId);

		return "redirect:/customer/list";
	}
}
