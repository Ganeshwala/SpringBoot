package com.springboot.security.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

	@Bean
	//Authentication
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails admin = User.withUsername("Admin").password(encoder.encode("Root@admin")).roles("ADMIN").build();
		
		UserDetails gernal = User.withUsername("Jhon").password(encoder.encode("asdfg")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin,gernal);
	}
	
	@Bean
	//Authentication
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity https) throws Exception {
		return https
			 .csrf(csrf->csrf.disable())
			 .authorizeHttpRequests((authorizeHttpRequests) ->
 				authorizeHttpRequests
 					.requestMatchers("/products/welcome").permitAll()
 					.requestMatchers("/products/all").hasAnyRole("ADMIN")
 					.requestMatchers("/products/id").hasRole("USER")
 					.anyRequest().authenticated()
			 )
			 .formLogin(Customizer.withDefaults())
			 .httpBasic(Customizer.withDefaults())
			 .build();
			 
	}
}
