package kh.com.kshrd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kh.com.kshrd.entities.Student;
@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<Student> getUserList() {
		
		// preparing user list with few hard coded values
		List<Student> userList = new ArrayList<Student>();
		
		userList.add(new Student(1, "user_a", "user_a@example.com", "9898989898"));
		userList.add(new Student(2, "user_b", "user_b@example.com", "9767989898"));
		userList.add(new Student(3, "user_c", "user_c@example.com", "9898459898"));
		
		return userList;
	}

}
