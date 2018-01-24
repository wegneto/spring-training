package com.wegneto.login;

public class LoginService {

	public boolean isUserValid(String user, String password) {
		if (user.equals("admin") && password.equals("dummy")) {
			return true;
		}
		
		return false;
	}
	
}
