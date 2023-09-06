package com.openclassrooms.p11api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// http.authorizeHttpRequests(
		// auth ->
		// auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll())
		// .authorizeHttpRequests(
		// auth ->
		// auth.requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).permitAll())
		// .headers(AbstractHttpConfigurer::disable)
		// .csrf(csrf ->
		// csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));
		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().permitAll())
				.csrf(AbstractHttpConfigurer::disable);
		return http.build();
	}
	/*
	 * @Bean public CorsConfigurationSource corsConfigurationSource() {
	 * CorsConfiguration configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("*"));
	 * configuration.setAllowedHeaders(Arrays.asList("*"));
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 */
}
