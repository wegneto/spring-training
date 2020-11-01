package com.wegneto.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.wegneto.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean someBoolean) {
		System.out.println(getClass() + ": ADDING ACOUNT...");
	}

	public boolean doSomething() {
		System.out.println(getClass() + ": DOING SOMETHING...");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ".getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ".setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ".getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ".setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts() {
		List<Account> result = new ArrayList<Account>();
		
		//create sample accounts
		Account acct1 = new Account();
		acct1.setName("Name 1");
		acct1.setLevel("Level 1");
		
		Account acct2 = new Account();
		acct1.setName("Name 2");
		acct1.setLevel("Level 2");
		
		Account acct3 = new Account();
		acct1.setName("Name 3");
		acct1.setLevel("Level 3");
		
		//add them to the list
		result.add(acct1);
		result.add(acct2);
		result.add(acct3);
		
		return result;
	}

}
