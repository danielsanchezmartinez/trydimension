package com.daniel.trydimension.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Autenticacion autenticacion;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		provider.setUserDetailsService(autenticacion);

		auth.authenticationProvider(provider);
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	        http
	        	.authorizeRequests()
	        		.antMatchers("/css/**").permitAll()
	        		.anyRequest().authenticated()
	            .and()
	            .formLogin()
	            	.loginPage("/login").permitAll()
	            	.defaultSuccessUrl("/trydimensionhome")
	            	.usernameParameter("username") 
	                .passwordParameter("password");
	}
	

}
