package com.wegneto.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wegneto.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// create a query
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

}