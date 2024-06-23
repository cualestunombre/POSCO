package ex02.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
import org.springframework.security.web.session.DisableEncodeUrlFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ex02.filter.MySecurityFilter01;
import ex02.filter.MySecurityFilter02;
import ex02.filter.MySecurityFilter03;
import ex02.filter.MySecurityFilter04;

@Configuration
public class SecurityConfig03 {
	
	@Bean
	public FilterChainProxy springSecurityFilterChain() {
		List<SecurityFilterChain> list = List.of(
				new DefaultSecurityFilterChain(new AntPathRequestMatcher("/assets/**")),
				new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"), disableEncodeUrlFilter(),securityContextFilter(),mySecurityFilter04(),webAysncManagerIntegrationFilter())
						
				);
		return new FilterChainProxy(list);
	}
	
	@Bean
	public DisableEncodeUrlFilter disableEncodeUrlFilter() {
		return new DisableEncodeUrlFilter();
	}
	
	
	@Bean
	public WebAsyncManagerIntegrationFilter webAysncManagerIntegrationFilter() {
		return new WebAsyncManagerIntegrationFilter();
	}
	
	@Bean
	public SecurityContextPersistenceFilter securityContextFilter() {
		return new SecurityContextPersistenceFilter();
	}
	@Bean
	public MySecurityFilter04 mySecurityFilter04() {
		return new MySecurityFilter04();
	}
}