package kh.com.kshrd.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import kh.com.kshrd.app.entities.Role;
import kh.com.kshrd.app.entities.User;

@Service("userServiceAPI")
public class UserServiceAPIImpl implements UserService{
	
	private static final String URL = "http://localhost:8080/06_12_2015_WebServiceServer/rest/users/login";
	
	@Autowired
	private HttpHeaders headers;			
	
	@Autowired 
	private RestTemplate restTemplate; 
	
	@Override
	public User findUserByUsername(String username) {
		try{
			HttpEntity<String> request = new HttpEntity<String>(username, headers);
			ResponseEntity<Map> responseEntity = restTemplate.exchange(URL+"/", HttpMethod.POST, request, Map.class);
			Map<String, Object> map = (HashMap<String, Object>)responseEntity.getBody();
			System.out.println(map.get("user"));
			ObjectMapper mapper = new ObjectMapper();
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

}
