package com.wegneto.aopdemo.dao;

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

}
