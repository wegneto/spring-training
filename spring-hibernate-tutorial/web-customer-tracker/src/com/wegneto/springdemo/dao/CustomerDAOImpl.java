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
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();

		// execute query and get result list
		Customer customer = session.get(Customer.class, customerId);

		return customer;
	}

	@Override
	public void delete(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id = :customerId");
		query.setParameter("customerId", customerId);

		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String customerName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = null;

		//
		// only search by name if theSearchName is not empty
		//
		if (customerName != null && customerName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			query = currentSession.createQuery(
					"from Customer where lower(firstName) like :customerName or lower(lastName) like :customerName",
					Customer.class);
			query.setParameter("customerName", "%" + customerName.toLowerCase() + "%");

		} else {
			// theSearchName is empty ... so just get all customers
			query = currentSession.createQuery("from Customer", Customer.class);
		}

		// execute query and get result list
		List<Customer> customers = query.getResultList();

		// return the results
		return customers;
	}

}