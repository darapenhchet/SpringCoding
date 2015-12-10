import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import kh.com.kshrd.entities.Student;

public class RestTemplateTesting {

	private static final String URL = "http://localhost:8080/ArticleManagementSpringRest/api/students";
	private RestTemplate restTemplate = new RestTemplate();

	private static HttpHeaders getAuthenticationHeader(String username, String password) {
		String credentials = username + ":" + password;
		String base64CredentialData = Base64.getUrlEncoder().encodeToString(credentials.getBytes());
		System.out.println(base64CredentialData);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic " + new String(base64CredentialData));
		return headers;
	}

	public String getAllStudents() {
		HttpHeaders headers = getAuthenticationHeader("admin", "admin");
		//ParameterizedTypeReference<List<Student>> responseType = new ParameterizedTypeReference<List<Student>>(){};
		HttpEntity<?> request = new HttpEntity<Object>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URL+"/", HttpMethod.GET, request, String.class);
		String students = responseEntity.getBody();
		return students;
	}

	public String deleteStudent(Long id) {
		HttpHeaders headers = getAuthenticationHeader("admin", "admin");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> request = new HttpEntity<Object>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "/{id}", HttpMethod.DELETE, request, String.class, id);
		return responseEntity.toString();
	}
	
	public String updateStudent(Student student) {
		HttpHeaders headers = getAuthenticationHeader("admin", "admin");
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Add the Jackson and String message converters
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		HttpEntity<?> request = new HttpEntity<Object>(student, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "/{id}", HttpMethod.PUT, request, String.class, student.getId());
		return responseEntity.toString();
	}
	
	public String addStudent(Student student) {
		HttpHeaders headers = getAuthenticationHeader("admin", "admin");
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		// Add the Jackson and String message converters
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	    
		HttpEntity<?> request = new HttpEntity<Object>(student, headers);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL +"/", request, String.class);
		return responseEntity.toString();
	}

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(10L);
		RestTemplateTesting rest = new RestTemplateTesting();
		System.out.println(rest.getAllStudents());
		System.out.println(rest.deleteStudent(1L));
		System.out.println(rest.addStudent(student));
		System.out.println(rest.updateStudent(student));
		
	}
}
