package kh.com.kshrd.app.controllers.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kh.com.kshrd.app.entities.Article;
import kh.com.kshrd.app.entities.Pagination;
import kh.com.kshrd.app.services.ArticleService;

@RestController
@RequestMapping(value="/rest/admin/articles")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findAllArticles(Pagination pagination){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("articles", articleService.findAll(pagination));
		pagination.setTotalCount(articleService.count());
		pagination.setTotalPages(pagination.totalPages());
		map.put("pagination", pagination);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> findArticleById(@PathVariable int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("article", articleService.findAriticleById(id));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> updateArticleById(@RequestBody Article article, @PathVariable int id){
		Map<String, Object> map = new HashMap<String, Object>();
		article.setId(id);
		map.put("status", articleService.updateArticle(article));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteArticleById(@PathVariable int id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", articleService.deleteArticleById(id));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
