package com.wegneto.springdemo.service;

import java.util.List;

import com.wegneto.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	void save(Customer customer);

	Customer findById(int customerId);

	void delete(int customerId);

	List<Customer> findByName(String customerName);

}
