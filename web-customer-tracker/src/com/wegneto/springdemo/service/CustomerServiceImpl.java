package com.wegneto.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wegneto.springdemo.dao.CustomerDAO;
import com.wegneto.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer findById(int customerId) {
		return customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		customerDAO.delete(customerId);
	}

	@Override
	@Transactional
	public List<Customer> findByName(String customerName) {
		return customerDAO.searchCustomer(customerName);
	}

}
