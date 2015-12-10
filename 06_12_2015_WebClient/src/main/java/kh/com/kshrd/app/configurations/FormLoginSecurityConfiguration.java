package kh.com.kshrd.app.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class FormLoginSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	// TODO: Autowired the UserDetailsService
	@Autowired
	@Qualifier(value="customUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO: In Memory Authentication Provider
		/*
		auth
			.inMemoryAuthentication()
			.withUser("user")
			.password("user")
			.roles("USER");
		*/
		
		// TODO: UserDetailsService Authentication Provider
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/authentication/**").permitAll();
		http
			.authorizeRequests()
				.anyRequest()
				.hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/admin/authentication/login")
				.defaultSuccessUrl("/admin/dashboard")
				.permitAll();
		
		http.rememberMe().key("remember-me");
		
		http.logout().permitAll();
	}
	
	// TODO: Bean PasswordEncoder with BcryptPasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
}