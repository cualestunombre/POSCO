package com.poscodx.mysite.config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import com.poscodx.mysite.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return new WebSecurityCustomizer() {
            @Override
            public void customize(WebSecurity web) {
                web
            		.ignoring()
            		.requestMatchers(new AntPathRequestMatcher("/assets/**"))
            		.requestMatchers(new AntPathRequestMatcher("/favicon.ico"))
            		.requestMatchers(new AntPathRequestMatcher("/upload-images/**"));
            }
        };
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(16);
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailService,PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		authenticationProvider.setUserDetailsService(userDetailService);
		return new ProviderManager(authenticationProvider);
	}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	String s= HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
    	
    	http
    		.logout()
    		.logoutUrl("/user/logout")
    		.logoutSuccessUrl("/")
    		.and()
    		.csrf().disable()
			.formLogin()
			.loginPage("/user/login")
			.loginProcessingUrl("/user/auth")
			.usernameParameter("email")
			.passwordParameter("password")
			.failureUrl("/user/login?result=failure")
			.and()
			.authorizeHttpRequests((auth)->{
				/*
				 * ACL
				 */
				auth
					.requestMatchers(new RegexRequestMatcher("^/user/update$", null))
					.hasAnyRole("ADMIN","USER")
					.requestMatchers(new AntPathRequestMatcher("/admin/**")) 
	                .hasRole("ADMIN")
	                .requestMatchers(new RegexRequestMatcher("^/board/(delete|modify|write|reply)(/.*)?$", null))
	                .hasAnyRole("ADMIN","USER")
					.anyRequest().permitAll();
					
			});
			
			
    	return http.build();
    }
}