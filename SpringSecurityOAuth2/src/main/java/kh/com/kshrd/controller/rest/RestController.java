package kh.com.kshrd.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.kshrd.entities.Student;
import kh.com.kshrd.services.UserService;

@Controller
@RequestMapping("/api/users")
public class RestController {

	@Autowired
	UserService dataService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> list() {
		return dataService.getUserList();

	}
}
