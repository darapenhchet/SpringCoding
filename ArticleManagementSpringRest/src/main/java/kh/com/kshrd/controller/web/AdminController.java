package kh.com.kshrd.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@RequestMapping(value="/users/")
	public String users(){
		return "users/lists";
	}
}
