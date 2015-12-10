package kh.com.kshrd.app.controllers.web;

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

import kh.com.kshrd.app.entities.Article;

@Controller
@RequestMapping(value="/articles")
public class ArticleController {
	
	private static final String URL = "http://localhost:8080/06_12_2015_WebServiceServer";
	
	@Autowired
	private HttpHeaders headers;			
	
	@Autowired 
	private RestTemplate restTemplate; 
	
	@RequestMapping(method=RequestMethod.GET)
	public String articleListPage(){
		return "admin/articles/list";
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllArticles() {
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<Map> response = restTemplate.exchange(
				URL + "/rest/admin/articles",
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
