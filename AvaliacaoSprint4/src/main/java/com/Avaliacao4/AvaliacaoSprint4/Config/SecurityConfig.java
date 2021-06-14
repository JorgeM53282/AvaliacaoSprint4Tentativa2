package com.Avaliacao4.AvaliacaoSprint4.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.Avaliacao4.AvaliacaoSprint4.Repository.UserRepository;
import com.Avaliacao4.AvaliacaoSprint4.Service.TokenService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Autentication autentication;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autentication).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configuracao(HttpSecurity Http) throws Exception{
		Http.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
			.antMatchers(HttpMethod.GET, "/pessoa").permitAll()
			
		
	}

	
	
	private static final String[] AUTH_WHITELIST = {"
}
