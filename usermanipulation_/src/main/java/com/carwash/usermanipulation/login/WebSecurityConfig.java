
  package com.carwash.usermanipulation.login; import java.util.Arrays;
  
	/*
	 * import org.springframework.beans.factory.annotation.Autowired; import
	 * org.springframework.context.annotation.Bean; import
	 * org.springframework.context.annotation.Configuration; import
	 * org.springframework.security.authentication.dao.DaoAuthenticationProvider;
	 * import
	 * org.springframework.security.config.annotation.authentication.builders.
	 * AuthenticationManagerBuilder; import
	 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
	 * import org.springframework.security.config.annotation.web.configuration.
	 * EnableWebSecurity; import
	 * org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter; import
	 * org.springframework.security.core.userdetails.UserDetailsService; import
	 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
	 * org.springframework.web.cors.CorsConfiguration; import
	 * org.springframework.web.cors.CorsConfigurationSource; import
	 * org.springframework.web.cors.UrlBasedCorsConfigurationSource;
	 * 
	 * @Configuration
	 * 
	 * @EnableWebSecurity public class WebSecurityConfig extends
	 * WebSecurityConfigurerAdapter {
	 * 
	 * @Autowired // private DataSource dataSource;
	 * 
	 * @Bean public UserDetailsService userDetailsService() { return new
	 * CustomUserDetailsService(); }
	 * 
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(userDetailsService());
	 * authProvider.setPasswordEncoder(passwordEncoder());
	 * 
	 * return authProvider; }
	 * 
	 * 
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 * configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("*"));
	 * configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT"));
	 * configuration.setAllowedHeaders(Arrays.asList("*"));
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 * 
	 * 
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.authenticationProvider(authenticationProvider()); }
	 * 
	 * 
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests() .antMatchers("/home").authenticated()
	 * .anyRequest().permitAll() .and() .formLogin() .usernameParameter("username")
	 * .defaultSuccessUrl("/welcome") .permitAll() .and()
	 * .logout().logoutSuccessUrl("/").permitAll(); }
	 * 
	 * 
	 * }
	 */