package kh.com.kshrd.app.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/authentication")
public class AuthenticationController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "auth/login";
	}
}
