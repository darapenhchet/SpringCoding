package kh.com.kshrd.entities;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 7248713876876221984L;
	
	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String classroom;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
}
