package com.wegneto.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wegneto.blog.service.UsuarioLogadoDetailService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioLogadoDetailService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/", "/auth/**", "/{permalink}", 
					"/search/**", "/autor/{id}/page/{page}", 
					"/categoria/{link}/page/{page}", "/page/{page}", 
					"/avatar/load/{id}").permitAll()
			.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/auth/login")
			.failureUrl("/auth/login?error=true")
			.usernameParameter("j_username")
			.passwordParameter("j_password")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/auth/login?logout=true")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
		.and()
			.exceptionHandling().accessDeniedPage("/auth/denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
