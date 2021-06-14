package com.Avaliacao4.AvaliacaoSprint4.Config;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Avaliacao4.AvaliacaoSprint4.Entity.User;
import com.Avaliacao4.AvaliacaoSprint4.Repository.UserRepository;
import com.Avaliacao4.AvaliacaoSprint4.Service.TokenService;

public class AuthTokenFilter extends OncePerRequestFilter{
	
	private TokenService TOKEN;
	
	private UserRepository userRepository;
	
	
	private String BuscaToken(HttpServletRequest request) {
		String token = request.getHeader("Autorização");
		if(token == null || token.isEmpty() || token.startsWith("Negado")) {
			return null;
		}
		return token.substring(10, token.length());
	}
	
	private void autorizado(String token) {
        Long id = TOKEN.id(token);
        try {
            User usuario = userRepository.findById(id).get();
            UsernamePasswordAuthenticationToken autorizado = new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(), null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autorizado);
        } catch (NoSuchElementException e) {
            System.out.println("Acesso Negado");
        }
    }
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = BuscaToken(request);
		boolean permitido = TOKEN.valido(token);
		if(permitido) {
			autorizado(token);
		}
		filterChain.doFilter(request, response);
	}
	
	

}
