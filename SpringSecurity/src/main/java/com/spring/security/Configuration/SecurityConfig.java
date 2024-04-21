package com.spring.security.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails normalUser = User.withUsername("normal")
									 .password(passwordEncoder().encode("Normal"))
									 .roles("Normal")
									 .build();
		
		UserDetails adminUser = User.withUsername("Admin")
				 .password(passwordEncoder().encode("Admin"))
				 .roles("Admin")
				 .build();
		
		UserDetails publicUser = User.withUsername("Public")
				 .password(passwordEncoder().encode("Public"))
				 .roles("Public")
				 .build();
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser,adminUser,publicUser);
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/home/admin")
		.hasRole("Admin")
		.requestMatchers("/home/normal")
		.hasRole("normal")
		.requestMatchers("/home/public")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		
		return httpSecurity.build();
	}
}
