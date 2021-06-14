package com.Avaliacao4.AvaliacaoSprint4.Service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.Avaliacao4.AvaliacaoSprint4.Entity.User;

@Service
public class TokenService {

	
	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	
	public String createToken(Authentication authentication) {
		User logado = (User)authentication.getPrincipal();
		Date hoje = new Date();
		Date date = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder().setIssuer("Sprint4").setSubject(logado.getId().toString()).setIssuedAt(date)
				.setExpiration(date).signWith(SignatureAlgorithm.HS256, secret).compact();
	}
	public boolean valido (String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	public Long id(String token) {
		Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claim.getSubject());
	}
	
}
