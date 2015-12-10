package kh.com.kshrd.services;

import java.util.List;

import kh.com.kshrd.entities.User;

public interface UserService {

	public User findUserById(Long id);
	
	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public Boolean saveUser(User user);
	
	public Boolean updateUser(User user);
	
	public List<User> getAllUsers();
	
	public Boolean updateUserStatus(Long id);
	
	public Boolean deleteUser(Long id);
}
