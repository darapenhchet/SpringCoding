package kh.com.kshrd.configuration.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
    private TokenStore tokenStore;
	
	/*@Autowired
    private UserApprovalHandler userApprovalHandler;*/
	
	@Bean
	public TokenStore tokenStore(){
		return new InMemoryTokenStore();
	}
	
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore)
			//.userApprovalHandler(userApprovalHandler)
			.authenticationManager(authenticationManager);
	
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
				.withClient("WebKAClient")
				.secret("webKASecret")
				.authorizedGrantTypes("password","implicit")
				.resourceIds("STUDENT_RESOURCE")
				.scopes("read", "write");
		
		clients
			.inMemory()
				.withClient("IOS_KA_CLIENT")
				.secret("IOS_KA_SECRET")
				.authorizedGrantTypes("password")
				.scopes("read");
		
		clients
			.inMemory()
				.withClient("ANDROID_KA_CLIENT")
				.secret("ANDROID_KA_SECRET")
				.authorizedGrantTypes("password")
				.scopes("read");
	}
	
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.realm("Article Management Spring REST");
    }

}
