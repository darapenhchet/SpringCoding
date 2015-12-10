package kh.com.kshrd.cofiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
	
	/*@Autowired
	private AuthenticationManager authenticationManager;
		
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager);
	}*/
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		super.configure(clients);
	 	clients.inMemory()
	        .withClient("my-trusted-client")
	            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
	            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
	            .scopes("read", "write", "trust")
	            .accessTokenValiditySeconds(60)
		    .and()
	        .withClient("my-client-with-registered-redirect")
	            .authorizedGrantTypes("authorization_code")
	            .authorities("ROLE_CLIENT")
	            .scopes("read", "trust")
	            .redirectUris("http://anywhere?key=value")
		    .and()
	        .withClient("my-client-with-secret")
	            .authorizedGrantTypes("client_credentials", "password")
	            .authorities("ROLE_CLIENT")
	            .scopes("read")
	            .secret("secret");
	}
	
}
