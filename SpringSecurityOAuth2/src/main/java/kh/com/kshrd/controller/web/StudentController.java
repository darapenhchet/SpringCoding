package kh.com.kshrd.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/user/")
	public String userProfile(){
		System.out.println("HELL WORLD");
		return "login";
	}
}
