package com.wegneto.blog.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.wegneto.blog.repository")
@EnableTransactionManagement
@PropertySource("classpath:/application.properties")
public class SpringDataConfig {

	@Autowired
	private Environment environment;

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory) {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		manager.setJpaDialect(new HibernateJpaDialect());
		return manager;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(environment.getProperty("hibernate.show.sql", Boolean.class));
		adapter.setGenerateDdl(environment.getProperty("hibernate.ddl", Boolean.class));
		return adapter;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setJpaProperties(properties);
		factory.setPackagesToScan(environment.getProperty("hibernate.package.scan"),
				environment.getProperty("java.time.jpa.converter"));
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Bean(name = "dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername(environment.getProperty("jdbc.user"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));

		return dataSource;
	}

}
