package ex02.config;

import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.AntPathMatcher;

import ex02.filter.MySecurityFilter01;
import ex02.filter.MySecurityFilter02;
import ex02.filter.MySecurityFilter03;
import ex02.filter.MySecurityFilter04;

public class SecurityConfig01 {
	
	@Bean
	public FilterChainProxy springSecurityFilterChain() {
		List<SecurityFilterChain> list = List.of(
				new SecurityFilterChain() {

					@Override
					public List<Filter> getFilters() {
						// 스프링 시큐리티 필터는 빈으로 등록되어 있어야 한다
						return List.of(mySecurityFilter01(),mySecurityFilter02(),mySecurityFilter03(),mySecurityFilter04());
					}

					@Override
					public boolean matches(HttpServletRequest request) {
						String uri = request.getRequestURI().replaceAll(request.getContextPath(), "");
						return new AntPathMatcher().match("/assets/**", uri);
					}
					
				},
				new SecurityFilterChain() {
				
					@Override
					public List<Filter> getFilters() {

						return null;
					}

					@Override
					public boolean matches(HttpServletRequest request) {
						
						return false;
					}
					
				});
		return new FilterChainProxy(list);
	}
	
	@Bean
	public MySecurityFilter01 mySecurityFilter01() {
		return new MySecurityFilter01();
	}
	@Bean
	public MySecurityFilter02 mySecurityFilter02() {
		return new MySecurityFilter02();
	}
	@Bean
	public MySecurityFilter03 mySecurityFilter03() {
		return new MySecurityFilter03();
	}
	@Bean
	public MySecurityFilter04 mySecurityFilter04() {
		return new MySecurityFilter04();
	}
}
