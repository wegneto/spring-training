package com.wegneto.springdemo.dao;

import java.util.List;

import com.wegneto.springdemo.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int customerId);

	void delete(int customerId);
	
}
