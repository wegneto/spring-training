package com.wegneto.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wegneto.aopdemo.dao.AccountDAO;
import com.wegneto.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doSomething();
		
		//call getter/setters
		accountDAO.setName("some name");
		accountDAO.getName();
		accountDAO.setServiceCode("some service code");
		accountDAO.getServiceCode();

		membershipDAO.addMemberAccount();
		membershipDAO.doSomethingElse();

		// close the context
		context.close();
	}

}
