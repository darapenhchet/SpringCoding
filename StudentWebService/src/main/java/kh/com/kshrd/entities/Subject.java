package kh.com.kshrd.entities;

import java.io.Serializable;

public class Subject implements Serializable{

	private static final long serialVersionUID = 1282388551323456178L;
	
	private Integer id;
	private String name;
	
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
	
}
