package com.wegneto.springdemo.service;

import java.util.List;

import com.wegneto.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int customerId);

	void delete(int customerId);

}
