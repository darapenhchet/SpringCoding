package kh.com.kshrd.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import kh.com.kshrd.entities.Student;

@Controller
@RequestMapping(value="/students")
public class StudentController {

	private static final String URL = "http://localhost:8080/ArticleManagementSpringRest/api/students";
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private HttpHeaders headers;
	
	@RequestMapping(value="/", method= RequestMethod.POST)
	@ResponseBody
	public String addStudent(@RequestBody Student student) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		// Add the Jackson and String message converters
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
	    
		HttpEntity<?> request = new HttpEntity<Object>(student, headers);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL +"/", request, String.class);
		return responseEntity.toString();
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	@ResponseBody
	public String getAllStudents() {
		//ParameterizedTypeReference<List<Student>> responseType = new ParameterizedTypeReference<List<Student>>(){};
		HttpEntity<?> request = new HttpEntity<Object>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URL+"/", HttpMethod.GET, request, String.class);
		String students = responseEntity.getBody();
		return students;
	}

	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@ResponseBody
	public String deleteStudent(@PathVariable("id") Long id) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> request = new HttpEntity<Object>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "/{id}", HttpMethod.DELETE, request, String.class, id);
		return responseEntity.toString();
	}
	
	@RequestMapping(value="/", method= RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String updateStudent(@RequestBody Student student) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Add the Jackson and String message converters
	    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		HttpEntity<?> request = new HttpEntity<Object>(student, headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(URL + "/{id}", HttpMethod.PUT, request, String.class, student.getId());
		return responseEntity.toString();
	}
}
