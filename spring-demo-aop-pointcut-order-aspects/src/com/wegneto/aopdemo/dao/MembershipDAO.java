package com.wegneto.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addMemberAccount() {
		System.out.println(getClass() + ": ADDING MEMBER ACOUNT...");
		return true;
	}
	
	public boolean doSomethingElse() {
		System.out.println(getClass() + ": DOING SOMETHING ElSE...");
		return false;
	}
	
}
