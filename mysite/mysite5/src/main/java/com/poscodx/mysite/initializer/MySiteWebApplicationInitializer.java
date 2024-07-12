package com.poscodx.mysite.initializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.poscodx.mysite.config.AppConfig;
import com.poscodx.mysite.config.WebConfig;

public class MySiteWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] {
				new CharacterEncodingFilter("UTF-8"), new DelegatingFilterProxy("springSecurityFilterChain")
		};
	}

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };  
    }
    
    // 찾는게 없으면 web.xml을 원래 참조하지만, NoHandlerFoundException을 던질 수 있게 설정해야 한다
    @Override
    protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
    	DispatcherServlet servlet = (DispatcherServlet)super.createDispatcherServlet(servletAppContext);
    	servlet.setThrowExceptionIfNoHandlerFound(true);
    	

    	return servlet;
    	
    	
    }
    

    
	

}
