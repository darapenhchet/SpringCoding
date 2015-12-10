import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

public class OAuth2ClientTest {
	
	private OAuth2RestTemplate restTemplate() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setClientId("WebKAClient");
		resourceDetails.setClientSecret("webKASecret");
		resourceDetails.setGrantType("password");
		resourceDetails.setAccessTokenUri("http://localhost:8080/ArticleManagementSpringRest/oauth/token");
		
		//SET SCOPES
		List<String> scopes = new ArrayList<>();
		scopes.add("read");
		scopes.add("write");
		resourceDetails.setScope(scopes);
		
		//RESOURCE OWNER DETAILS
		resourceDetails.setUsername("admin");
		resourceDetails.setPassword("admin");
		
		return new OAuth2RestTemplate(resourceDetails);
	}
	
	public static void main(String[] args) {
		OAuth2ClientTest client = new OAuth2ClientTest();
		RestTemplate restTemplate = client.restTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/ArticleManagementSpringRest/api/students/",String.class);
		if(HttpStatus.OK.equals(responseEntity.getStatusCode())){
			String students = responseEntity.getBody();
			System.out.println(students);
		}else if(HttpStatus.UNAUTHORIZED.equals(responseEntity.getStatusCode())){
			System.out.println("UN AUTHORIZATION...");
		}else{
			System.out.println("ERROR...");
		}
	}

}
