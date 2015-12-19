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

import kh.com.kshrd.entities.Role;
import kh.com.kshrd.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public User getUserByUsername(String username) {
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
				user.setPassword(rs.getString("password"));
				user.setStatus(rs.getString("status"));
				user.setRoles(this.findAllRolesByUserId(user.getId()));
				return user;
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return null;
	}

	public List<Role> findAllRolesByUserId(int id){
		List<Role> roles = new ArrayList<Role>();
		String sql = "SELECT roles.id "
						+ ", roles.name "
						+ "FROM users "
						+ "LEFT JOIN user_roles ON users.id = user_roles.user_id "
						+ "LEFT JOIN roles ON roles.id = user_roles.role_id "
						+ "WHERE users.id = ?";
		try(
			Connection cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
		){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				roles.add(role);
			}
		} catch (SQLException e) {
			System.out.println(e);
		};
		return roles;
	}

}
