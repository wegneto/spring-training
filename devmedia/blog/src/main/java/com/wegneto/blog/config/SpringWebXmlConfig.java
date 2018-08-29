package com.wegneto.blog.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebXmlConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		servletContext.addListener(new ContextLoaderListener(webContext));
		
		webContext.register(SpringMvcConfig.class);
		webContext.setServletContext(servletContext);

		DispatcherServlet dispatcher = new DispatcherServlet(webContext);
		dispatcher.setThrowExceptionIfNoHandlerFound(true);

		ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcher);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/");
		
		FilterRegistration.Dynamic encondingFilter = servletContext.addFilter("encondingFilter", new CharacterEncodingFilter());
		encondingFilter.setInitParameter("encoding", "UTF-8");
		encondingFilter.setInitParameter("forceEncoding", "true");
		encondingFilter.addMappingForUrlPatterns(null, true, "/*");
		
		FilterRegistration.Dynamic inViewSession = servletContext.addFilter("Spring OpenEntityManagerInViewFilter", new OpenEntityManagerInViewFilter());
		inViewSession.setAsyncSupported(true);
		inViewSession.addMappingForUrlPatterns(null, true, "/*");
	}

}
