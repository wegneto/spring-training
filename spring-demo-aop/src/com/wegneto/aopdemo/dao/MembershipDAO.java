package com.wegneto.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addMemberAccount() {
		System.out.println(getClass() + ": ADDING MEMBER ACOUNT...");
	}
	
}
