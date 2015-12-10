package kh.com.kshrd.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.kshrd.entities.Student;

@Controller
public class StudentController {

	@RequestMapping(value={"/","/home"})
	public String home(){
		return "/WEB-INF/jsp/views/home.jsp";
	}
	
	@RequestMapping(value={"/student"}, method=RequestMethod.POST)
	public  String addNewStudent(Model model, @ModelAttribute Student student){
		System.out.println("STUDENT =" + student.getName());
		model.addAttribute("name", student.getName());
		return "home";
	}
}
