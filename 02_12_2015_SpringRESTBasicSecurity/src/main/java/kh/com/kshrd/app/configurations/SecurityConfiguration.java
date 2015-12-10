package kh.com.kshrd.app.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kh.com.kshrd.app.services.CustomUserDetailsService;

/*@Configuration
@EnableWebSecurity(debug=true)
//@ComponentScan(basePackages="kh.com.kshrd.app")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		    // Spring Security should completely ignore URLs starting with /resources/
			.antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.inMemoryAuthentication()
				.withUser("admin")
				.password("admin")
				.roles("ADMIN");
		auth	
			.inMemoryAuthentication()
				.withUser("user")
				.password("user")
				.roles("USER");
		
		auth.userDetailsService(userDetailsService);
			//.passwordEncoder(passwordEncoder());
		
		//auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/rest/**").permitAll();
		http
			.authorizeRequests()
				.antMatchers("/admin")
				.hasAnyRole("ADMIN");
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated();
		http
			.formLogin()
			.permitAll();
		
		http.csrf().disable();
		
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}*/
