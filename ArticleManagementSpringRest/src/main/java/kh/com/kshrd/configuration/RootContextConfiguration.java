package kh.com.kshrd.configuration;

import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(basePackages = "kh.com.kshrd",
			   excludeFilters = @ComponentScan.Filter({Controller.class,RestController.class}))
@Import(SpringSecurityConfiguration.class)
public class RootContextConfiguration {

	@Bean
	public HttpHeaders getAuthenticationHeader() {
		String credentials = "admin" + ":" + "admin";
		String base64CredentialData = Base64.getUrlEncoder().encodeToString(credentials.getBytes());
		System.out.println(base64CredentialData);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + new String(base64CredentialData));
		return headers;
	}
}
