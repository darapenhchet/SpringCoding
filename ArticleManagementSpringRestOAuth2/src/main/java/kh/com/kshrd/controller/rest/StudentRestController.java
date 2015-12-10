package kh.com.kshrd.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kh.com.kshrd.entities.Student;

@RestController
@RequestMapping(value="/api/students")
public class StudentRestController {

	@RequestMapping(value="/", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> getAllStudents(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("METHOD", "GET ALL STUDENTS");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> addStudent(@RequestBody Student student){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("METHOD", "ADD NEW STUDENT");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> updateStudent(@RequestBody Student student){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("METHOD", "UPDATE STUDENT");
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Map<String, Object>> deleteStudent(@PathVariable("id") Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("METHOD", "DELETE A STUDENT");
		map.put("ID", id);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
