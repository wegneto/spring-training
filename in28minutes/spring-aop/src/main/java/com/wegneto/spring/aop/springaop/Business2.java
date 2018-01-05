package com.wegneto.spring.aop.springaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
	@Autowired
	private Dao2 dao2;
	
	public String calculateSomething() {
		return dao2.retrieveSomething();
	}
}
