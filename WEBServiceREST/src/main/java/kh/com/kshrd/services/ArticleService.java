package kh.com.kshrd.services;

import java.util.List;

import kh.com.kshrd.entities.Article;
import kh.com.kshrd.entities.Pagination;

public interface ArticleService {

	public List<Article> findAll(Pagination pagination);
	
	public Article findAriticleById(int id);
	
	public boolean deleteArticleById(int id);
	
	public boolean updateArticle(Article article);
	
	public int count();
	
}
