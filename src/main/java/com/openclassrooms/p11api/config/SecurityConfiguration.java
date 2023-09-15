package com.openclassrooms.p11api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// CONFIG H2
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).permitAll())
				.headers(AbstractHttpConfigurer::disable)
				.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))

				.authorizeHttpRequests(
						auth -> auth.requestMatchers(AntPathRequestMatcher.antMatcher("/patient/urgence")).permitAll())
				.headers(AbstractHttpConfigurer::disable)
				.csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/patient/urgence")));

		return http.build();
	}

}
