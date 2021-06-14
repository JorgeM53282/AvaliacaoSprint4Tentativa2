package com.Avaliacao4.AvaliacaoSprint4.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.Avaliacao4.AvaliacaoSprint4.Entity.User;
import com.Avaliacao4.AvaliacaoSprint4.Repository.UserRepository;

public class Autentication implements UserDetailsService{

	@Autowired
	private UserRepository useR;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = useR.findByEmail(username);
		if(user.isPresent()) {
			return user.get();
		}
		
		throw new UsernameNotFoundException("Acesso Negado");
	}

}
