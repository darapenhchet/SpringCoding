package kh.com.kshrd.app.services;

import org.springframework.security.authentication.AuthenticationManager;

import kh.com.kshrd.app.entities.User;

public interface UserService {

	public User findUserByUsername(String username);
	
	
}
