package kh.com.kshrd.app.configurations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@Order(1)
public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	// TODO: Autowired the UserDetailsService
	@Autowired
	@Qualifier(value="customAPIUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired
	@Qualifier(value="RESTAuthenticationEntryPoint")
	private AuthenticationEntryPoint authenticationEntryPoint; 
	
	// TODO: Configuration AuthenticationManager
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO: In Memory Authentication Provider
		/*
		auth
			.inMemoryAuthentication()
				.withUser("API_KEY")
				.password("API_KEY")
				.roles("ADMIN");
		*/
		
		// TODO: UserDetailsService Authentication Provider
		//auth.userDetailsService(userDetailsService)
		//	.passwordEncoder(passwordEncoder());
		
		// TODO: DaoAutenticationProvider
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/rest/**")
			.authorizeRequests()
				.anyRequest()
				.hasRole("API_KEY").and()
			.httpBasic();
				//.authenticationEntryPoint(authenticationEntryPoint);
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);

		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
/*	private AuthenticationEntryPoint authenticationEntryPoint(){
		AuthenticationEntryPoint authenticationEntryPoint = new AuthenticationEntryPoint() {
			@Override
			public void commence(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException authException) throws IOException, ServletException {
				response.setContentType("application/json");
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
				response.getOutputStream().println("{\"error\":\""+authException.getMessage()+"\"}");
			}
		};
		return authenticationEntryPoint;
	}*/
	
	// TODO: Bean DaoAuthenticationProvider
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	// TODO: Bean PasswordEncoder with BcryptPasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	/*public static void main(String args[]){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		System.err.println(encoder.encode(id));
	}*/
}