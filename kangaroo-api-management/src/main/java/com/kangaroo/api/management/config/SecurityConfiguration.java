package com.kangaroo.api.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.kangaroo.api.management.security.AuthFailureHandler;
import com.kangaroo.api.management.security.AuthSuccessHandler;
import com.kangaroo.api.management.security.CustomUserDetailsService;
import com.kangaroo.api.management.security.HttpAuthenticationEntryPoint;
import com.kangaroo.api.management.security.HttpLogoutSuccessHandler;
import com.kangaroo.api.management.security.TokenAuthenticationFilter;
import com.kangaroo.utils.redis.RedisHelper;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final String LOGIN_PATH = "/login";
	private static final String LOGOUT_PATH = "/logout";

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private HttpAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private AuthSuccessHandler authSuccessHandler;
	@Autowired
	private AuthFailureHandler authFailureHandler;
	@Autowired
	private HttpLogoutSuccessHandler logoutSuccessHandler;
	@Autowired
	private RedisHelper redisHelper;
	

	@Value("${management.context-path}")
	private String managementContext;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(customUserDetailsService);
		authenticationProvider.setHideUserNotFoundExceptions(false);
		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		
		http.csrf().disable();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(new TokenAuthenticationFilter(redisHelper),
				UsernamePasswordAuthenticationFilter.class);
		
		
		http.authorizeRequests().antMatchers(managementContext + "/**").permitAll();
		http.authorizeRequests().antMatchers("/swagger-ui.html", "/v2/api-docs").permitAll().anyRequest()
				.authenticated();

		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

		http.formLogin().permitAll().loginProcessingUrl(LOGIN_PATH).successHandler(authSuccessHandler)
				.failureHandler(authFailureHandler);

		http.logout().permitAll().logoutUrl(LOGOUT_PATH).logoutSuccessHandler(logoutSuccessHandler);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/swagger-resources/**");
	}
}
