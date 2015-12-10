package kh.com.kshrd.app.configurations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*@EnableWebSecurity
public class MultipleHttpSecurityConfiguration {
	
	@Configuration
	@Order(1)
	public class APISecurityConfiguration extends WebSecurityConfigurerAdapter {
	
		// TODO: Autowired the UserDetailsService
		@Autowired
		@Qualifier(value="customAPIUserDetailsService")
		private UserDetailsService userDetailsService;
		
		// TODO: Configuration AuthenticationManager
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO: In Memory Authentication Provider
			
	//		auth
	//			.inMemoryAuthentication()
	//				.withUser("API_KEY")
	//				.password("API_KEY")
	//				.roles("ADMIN");
			
			
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
					.hasRole("ADMIN")
					.and()
				.httpBasic();
			
			http.csrf().disable();
			http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		}
		
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
		
		public static void main(String args[]){
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			String id = UUID.randomUUID().toString();
			System.out.println(id);
			System.err.println(encoder.encode(id));
		}
	}
	
	@Configuration
	@EnableWebSecurity
	@Order(2)
	public class FormLoginSecurityConfiguration extends WebSecurityConfigurerAdapter{
		
		// TODO: Autowired the UserDetailsService
		@Autowired
		@Qualifier(value="customUserDetailsService")
		private UserDetailsService userDetailsService;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			// TODO: In Memory Authentication Provider
			
//			auth
//				.inMemoryAuthentication()
//				.withUser("user")
//				.password("user")
//				.roles("USER");
			
			
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
					.anyRequest()
					.hasRole("ADMIN")
					.and()
				.formLogin()
					.loginPage("/admin/authentication/login")
					.defaultSuccessUrl("/admin/dashboard")
					.permitAll();
		}
		
		// TODO: Bean PasswordEncoder with BcryptPasswordEncoder
		@Bean
		public PasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder();
		}
		
	}
	
}
*/