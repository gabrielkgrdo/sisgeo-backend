package com.kleyber.SISGEO.security;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	
	//@Value("${jwt.expirationInDays}")
	//private int expirationInDays;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String gerarToken(String email) {
		
		Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.HOUR_OF_DAY, 1);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate.getTime())
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}

	public boolean tokenValido(String token) {
		Claims reivindicacoes = getReividicacoes(token);
		if(reivindicacoes != null) { 
			String username = reivindicacoes.getSubject();
			Date expirationDate = reivindicacoes.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			
			// Calcule a diferença em milissegundos entre a data de expiração e a data atual
	        long diffMillis = expirationDate.getTime() - now.getTime();
	        
	        // Converta a diferença de milissegundos para horas
	        long diffHours = diffMillis / (60 * 60 * 1000); // 1 hora = 60 minutos * 60 segundos * 1000 milissegundos

	        // Verifique se a diferença é maior que zero, o que significa que o token ainda é válido
	        if (username != null && expirationDate != null && diffHours > 0) {
	            return true;
			}
		}
		return false;
	}
	

	private Claims getReividicacoes(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
			} catch (Exception e) { 
			return null;  
		}
		
	}

	public String getUsername(String token) {
		Claims reivindicacoes = getReividicacoes(token);
		if(reivindicacoes != null) {
			return reivindicacoes.getSubject();
		}
		return null;
	}

}
