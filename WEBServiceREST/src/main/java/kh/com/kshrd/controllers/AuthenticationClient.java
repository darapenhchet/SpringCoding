package kh.com.kshrd.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.kshrd.services.UserService;

@Controller
public class AuthenticationClient {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/authenticate", method= RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> authenticateUser(@RequestBody String username){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", userService.getUserByUsername(username));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

}












