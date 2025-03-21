package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	 @Bean
	     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.cors().and()
	            .csrf().disable()
	            .authorizeHttpRequests(auth -> auth
	                // ✅ Allow Swagger endpoints without login
	            	.requestMatchers("/api/auth/**").permitAll()
	                .requestMatchers(
	                    "/swagger-ui/**", 
	                    "/v3/api-docs/**", 
	                    "/swagger-resources/**", 
	                    "/webjars/**"
	                ).permitAll()
	                
	                // Other APIs require authentication
	                .anyRequest().authenticated()
	            );

	        return http.build();
	    }
}
