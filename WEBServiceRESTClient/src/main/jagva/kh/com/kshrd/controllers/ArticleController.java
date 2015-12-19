package kh.com.kshrd.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import kh.com.kshrd.entities.Article;

@Controller
@RequestMapping(value="/articles")
public class ArticleController {
	
	private static final String URL = "http://localhost:8080/WEBServiceREST/";
	
	@RequestMapping(method=RequestMethod.GET)
	public String articleListPage(){
		return "admin/articles/list";
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllArticles() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic S0FfV0VCX0FQSV9LRVk6YWRtaW4=");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<Map> response = restTemplate.exchange(
				URL + "/api/admin/articles",
				HttpMethod.GET, entity,
				Map.class);
		System.out.println(response);
		return new ResponseEntity<Map<String, Object>>(response.getBody(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findArticle(@PathVariable int id){
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> createNewArticle(@RequestBody Article article){
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> deleteArticle(@PathVariable int id, @RequestBody Article article){
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> updateArticle(@PathVariable int id){
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
		
}
