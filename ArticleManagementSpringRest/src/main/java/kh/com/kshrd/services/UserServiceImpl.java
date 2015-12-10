package kh.com.kshrd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Role;
import kh.com.kshrd.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public User findUserByUsername(String username) {
		String sql = "SELECT id,username,password, status from users where username = ?";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setStatus(rs.getString("status"));
				return user;
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return null;
	}

	public List<Role> findAllRolesByUser(User user){
		return null;
	}

}
