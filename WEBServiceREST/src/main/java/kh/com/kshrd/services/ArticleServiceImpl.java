package kh.com.kshrd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Article;
import kh.com.kshrd.entities.Pagination;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Article> findAll(Pagination pagination) {
		List<Article> articles = new ArrayList<Article>();
		String sql = "SELECT articles.id " 
						+ ", articles.title "
						+ ", articles.content "
						+ ", users.username AS created_by "
						+ ", articles.created_date "
						+ ", articles.status "
						+ "FROM articles "
						+ "LEFT JOIN users ON articles.created_by = users.id "
						//+ "WHERE articles.status = '1' "
						+ "ORDER BY articles.id "
						+ "LIMIT ? OFFSET ?";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ps.setInt(1, pagination.getPerPage());
			ps.setInt(2, pagination.offset());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setCreatedBy(rs.getString("created_by"));
				article.setCreatedDate(rs.getString("created_date"));
				article.setStatus(rs.getString("status"));
				articles.add(article);
			}
			return articles;
		} catch (SQLException e) {
			System.out.println(e);
		};
		return null;
	}
	
	@Override
	public Article findAriticleById(int id) {
		String sql = "SELECT articles.id " 
				+ ", articles.title "
				+ ", articles.content "
				+ ", users.username AS created_by "
				+ ", articles.created_date "
				+ ", articles.status "
				+ "FROM articles "
				+ "LEFT JOIN users ON articles.created_by = users.id "
				+ "WHERE articles.id = ? "
				+ "AND articles.status = '1'";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setCreatedBy(rs.getString("created_by"));
				article.setCreatedDate(rs.getString("created_date"));
				article.setStatus(rs.getString("status"));
				return article;
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return null;
	}
	
	@Override
	public boolean updateArticle(Article article) {
		String sql = "UPDATE articles "
				   + "SET title = ? , content = ?, status = ?"
				   + "WHERE id = ?";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getContent());
			ps.setString(3, article.getStatus());
			ps.setInt(4, article.getId());
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return false;
	}
	
	@Override
	public boolean deleteArticleById(int id) {
		String sql = "DELETE FROM articles WHERE id = ?";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ps.setInt(1, id);
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return false;
	}
	
	
	@Override
	public int count() {
		String sql = "SELECT COUNT(id) AS count "
				   + "FROM articles";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return 0;
	}

}
