package com.kleyber.SISGEO.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.expiration}")
	private Long expiration;

	@Value("${jwt.secret}")
	private String secret;

	public String gerarToken(String email, Collection<? extends GrantedAuthority> autoridades) {
		return Jwts.builder()
				.setSubject(email)
				.claim("roles", autoridades)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}

	public boolean tokenValido(String token) {
		Claims reivindicacoes = getReividicacoes(token);
		if (reivindicacoes != null) {
			String username = reivindicacoes.getSubject();
			Date expirationDate = reivindicacoes.getExpiration();
			Date now = new Date(System.currentTimeMillis());

			if (username != null && expirationDate != null && now.before(expirationDate)) {
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
		if (reivindicacoes != null) {
			return reivindicacoes.getSubject();
		}
		return null;
	}

}
