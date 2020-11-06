package com.wegneto.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wegneto.aopdemo.dao.AccountDAO;

public class AfterDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;
		
		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain Program: catch exception: " + e.getMessage());
		}
		
		System.out.println("\n\nMain Program: AfterDemoApp");
		System.out.println("----");
		
		System.out.println(accounts);
		
		System.out.println("\n");

		// close the context
		context.close();
	}
}