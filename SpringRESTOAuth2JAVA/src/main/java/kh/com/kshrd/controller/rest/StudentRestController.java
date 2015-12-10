package kh.com.kshrd.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kh.com.kshrd.entities.Student;

@RestController
@RequestMapping("/api/")
public class StudentRestController {

	@RequestMapping(value="students", produces="application/json")
	public ResponseEntity<Student> students(){
		Student student = new Student();
		student.setId(1);
		student.setName("DARA PENHCHET");
		student.setGender("MALE");
		student.setEmail("darapenhchet@gmail.com");
		student.setClassroom("PHNOM PENH");
		student.setPhone("086961919");
		student.setPhoto("darapenhchet.png");
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
}
