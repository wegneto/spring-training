package com.wegneto.spring.microsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class MicroService {

	@RequestMapping("/")
    @ResponseBody
    public String home() {
          return "This is a micro-service!";
    }
    
    public static void main(String args[]) {
          SpringApplication.run(MicroService.class, args);
    }
	
}
