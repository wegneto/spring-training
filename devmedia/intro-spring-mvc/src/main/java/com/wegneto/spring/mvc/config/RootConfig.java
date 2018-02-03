package com.wegneto.spring.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.wegneto.spring.mvc")
@EnableWebMvc
public class RootConfig {

}
