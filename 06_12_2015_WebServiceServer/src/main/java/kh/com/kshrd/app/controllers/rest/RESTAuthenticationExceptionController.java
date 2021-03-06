package kh.com.kshrd.app.controllers.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/authentication")
public class RESTAuthenticationExceptionController {

	@RequestMapping(value="/unauthorized", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> unAuthorizedException(HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", HttpStatus.UNAUTHORIZED.value());
		map.put("status", HttpStatus.UNAUTHORIZED);
		map.put("message", request.getAttribute("message"));
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.UNAUTHORIZED);
	}
}
