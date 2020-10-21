package com.wegneto.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.wegneto.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account) {
		System.out.println(getClass() + ": ADDING ACOUNT...");
	}

}
