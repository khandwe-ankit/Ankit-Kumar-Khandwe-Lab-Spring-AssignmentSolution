package com.example.abccollege.studentmanagementservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.abccollege.studentmanagementservice.serviceimpl.UserDetailsServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(autheticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable().cors().disable()
				.authorizeRequests()
				.antMatchers("/", "/students/save", "/students/add", "/students/403").hasAnyAuthority("User", "Admin")
				.antMatchers("/students/update", "/students/delete").hasAuthority("Admin")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginProcessingUrl("/login").successForwardUrl("/students/list").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/students/403");
//				.and()
//				.httpBasic();

	}

	@Bean
	public AuthenticationProvider autheticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailService() {
		return new UserDetailsServiceImpl();
	}
}
