package kh.com.kshrd.app.controllers.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kh.com.kshrd.app.entities.User;
import kh.com.kshrd.app.services.UserService;

@RestController
@RequestMapping(value="/rest/users")
public class UserRestController {

	@Autowired
	@Qualifier("userServiceJDBC")
	UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> findUserByUsername(@RequestBody String username){
		System.out.println(username);
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.findUserByUsername(username);
		map.put("user", userService.findUserByUsername(username));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
}
