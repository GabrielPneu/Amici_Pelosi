package com.fpt.petstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

/**
 * Configurações de segurança para a aplicação, com foco na autenticação e autorização.
 *
 * - Configura o CORS para permitir requisições de origens específicas.
 * - Desabilita a proteção CSRF e libera acesso para rotas públicas.
 * - Configura o uso do BCrypt para criptografia de senhas.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder customPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity securityConfig) throws Exception {
		securityConfig
				.authorizeRequests()
				.antMatchers("/", "/api-docs").permitAll();

		securityConfig.csrf().disable();
		securityConfig.cors();
		securityConfig.headers().frameOptions().disable();
	}

	@Bean
	public CorsConfigurationSource customCorsConfiguration() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowCredentials(false);
		corsConfig.addAllowedOrigin("http://localhost:3000");
		corsConfig.setAllowedOriginPatterns(Collections.singletonList("*"));
		corsConfig.addAllowedHeader("*");
		corsConfig.addAllowedMethod("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
}
