package kh.com.kshrd.services;

import kh.com.kshrd.entities.User;

public interface UserService {

	public User findUserByUsername(String username);
	
}
