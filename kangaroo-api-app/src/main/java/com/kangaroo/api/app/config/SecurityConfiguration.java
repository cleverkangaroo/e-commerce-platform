package com.kangaroo.api.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;

import com.kangaroo.api.app.security.AuthFailureHandler;
import com.kangaroo.api.app.security.AuthSuccessHandler;
import com.kangaroo.api.app.security.CustomAccessDecisionManager;
import com.kangaroo.api.app.security.CustomAccessDeniedHandler;
import com.kangaroo.api.app.security.CustomUserDetailsService;
import com.kangaroo.api.app.security.HttpAuthenticationEntryPoint;
import com.kangaroo.api.app.security.HttpLogoutSuccessHandler;
import com.kangaroo.api.app.security.TokenAuthenticationFilter;
import com.kangaroo.microservices.api.base.service.UsersService;
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

	
	@Autowired
	private CustomAccessDecisionManager customAccessDecisionManager;

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

		CustomAccessDeniedHandler accessDeiedHandler = new CustomAccessDeniedHandler();
		http.exceptionHandling().accessDeniedHandler(accessDeiedHandler);

		http.authorizeRequests().antMatchers(managementContext + "/**").permitAll();
		http.authorizeRequests().antMatchers("/swagger-ui.html", "/v2/api-docs").permitAll();

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
