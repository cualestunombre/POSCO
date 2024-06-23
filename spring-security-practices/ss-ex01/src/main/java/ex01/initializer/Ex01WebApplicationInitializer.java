package ex01.initializer;

import javax.servlet.Filter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ex01.config.AppConfig;
import ex01.config.WebConfig;

public class Ex01WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// delegatingFilterProxy가 있어야 Spring Bean에 등록된 프록시 필터를 가져온다
		return new Filter[] {new DelegatingFilterProxy("myFilter")};
	}
}
