package kh.com.kshrd.cofiguration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http
			// Just for laughs, apply OAuth protection to only 2 resources
			.requestMatchers()
				.antMatchers("/","/admin")
				.and()
			.authorizeRequests()
				.anyRequest()
			.access("#oauth2.hasScope('read')");
	}

	
}
