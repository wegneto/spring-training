package com.wegneto.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wegneto.login.LoginService;

@Controller
public class LoginController {
	
	private LoginService service = new LoginService();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {
		if (service.isUserValid(name, password)) {
			model.put("name", name);
			return "welcome";
		} else {
			model.put("errorMessage", "Invalid credentials!");
			return "login";
		}
	}
	
}
