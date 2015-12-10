package kh.com.kshrd.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kh.com.kshrd.entities.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	/*@RequestMapping(value="/students", produces="application/json")
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
	}*/
	
	@RequestMapping(value="/students", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Boolean addNewStudent(@RequestBody Student student){
		return true;
	}
}
