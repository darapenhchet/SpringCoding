package kh.com.kshrd.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping(value={"/","/home"})
	public String home(){
		return "/WEB-INF/jsp/views/home.jsp";
	}
}
