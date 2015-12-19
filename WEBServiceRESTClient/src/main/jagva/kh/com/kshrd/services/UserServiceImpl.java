package kh.com.kshrd.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kh.com.kshrd.entities.Role;
import kh.com.kshrd.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	String url = "http://localhost:8080/WEBServiceREST/";
	
	@Override
	public User getUserByUsername(String username) {
		try{
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic S0FfV0VCX0FQSV9LRVk6YWRtaW4=");
			HttpEntity<String> requestBody = new HttpEntity<String>(username, headers);
			
			
			ResponseEntity<Map> response = 
						restTemplate.exchange(url+"api/authenticate"
											, HttpMethod.POST
											, requestBody
											, Map.class);
				
			Map<String, Object> map = (HashMap<String, Object>)response.getBody();
			System.out.println(map.get("user"));
			Map<String, Object> userMap = (HashMap<String, Object>) map.get("user");
			User user = new User(); 
			user.setId((int)userMap.get("id"));
			user.setUsername((String)userMap.get("username"));
			user.setPassword((String)userMap.get("password"));
			user.setStatus((String)userMap.get("status"));
			List<HashMap<String, Object>> rolesMap = (ArrayList<HashMap<String, Object>>) userMap.get("roles");
			List<Role> roles = new ArrayList<Role>();
			for(Map<String, Object> roleMap : rolesMap){
				Role role = new Role();
				role.setId((int)roleMap.get("id"));
				role.setName((String)roleMap.get("name"));
				roles.add(role);
			}
			user.setRoles(roles);
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserServiceImpl test = new UserServiceImpl();
		test = new UserServiceImpl();
		test.getUserByUsername("admin");
		
		//System.out.println(java.util.Base64.getUrlEncoder().encode("KA_WEB_API_KEY:admin"));
	}

}
