package com.wegneto.spring.mvc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringJpaConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		return null;
	}
	
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		return null;
	}
	
	public Properties jpaProperties() {
		return null;
	}
	
}
