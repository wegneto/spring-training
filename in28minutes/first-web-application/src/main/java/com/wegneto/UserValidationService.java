package com.wegneto;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("admin") && password.equals("dummy")) {
			return true;
		}
		
		return false;
	}
	
}
