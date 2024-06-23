package ex02.filter;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.servlet.Filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import ex02.config.SecurityConfig01;
import ex02.config.SecurityConfig02;
import ex02.config.SecurityConfig03;
import ex02.config.WebConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {WebConfig.class,SecurityConfig03.class})
@WebAppConfiguration
public class SecurityConfig02Test03 {
	private MockMvc mvc;
	
	@Autowired
	private FilterChainProxy proxy;
	
	@BeforeEach
	public void setup(ApplicationContext applicationContext) {
		mvc = MockMvcBuilders
				.webAppContextSetup((WebApplicationContext) applicationContext)
				.addFilter(new DelegatingFilterProxy(proxy), "/*")
				.build();
	}
	
	@Test
	public void testSecurityFilterChains() {
		List<SecurityFilterChain> chains = proxy.getFilterChains();
		assertEquals(chains.size(),2);
	}
	
	
	@Test
	public void testSecurityFilters() {
		SecurityFilterChain securityFilterChain = proxy.getFilterChains().get(1);
		List<Filter> filters = securityFilterChain.getFilters();
		assertEquals(filters.size(),4);
		
	}
	
	@Test
	public void testSecurityFilterChain01() throws Exception {
		mvc
			.perform(get("/assets/images/logopng"))
			.andExpect(status().isNotFound())
			.andExpect(cookie().doesNotExist("MySecurityFilter01"));
			
		
	}
}