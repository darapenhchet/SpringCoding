package kh.com.kshrd.app.services;

import kh.com.kshrd.app.entities.User;

public interface UserService {

	public User findUserByUsername(String username);
	
	
}
