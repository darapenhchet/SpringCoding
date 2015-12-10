package kh.com.kshrd.cofiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user")
					.password("password")
					.roles("USER")
					.and()
				.withUser("admin")
					.password("password")
					.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
        		.antMatchers("/api/*").hasRole("USER")
        		.anyRequest().permitAll()
        		.and()
        	.logout()
        		.logoutSuccessUrl("/login.jsp")
        		.permitAll()
        		.and()
        	.formLogin()
        		.loginProcessingUrl("/login")
        		.loginPage("/login.jsp")
        		.failureUrl("/login.jsp?authentication_error=true")
        		.permitAll();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	

}
