package com.demo.hibernate.sample.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Courses {
	
	@Id
	private int rollNo;
	private String courseName;
	@ManyToMany
	private List<UserDemo> usr = new ArrayList<UserDemo>(); 
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	@Override
	public String toString() {
		return "Courses [rollNo=" + rollNo + ", courseName=" + courseName + "]";
	}
	public List<UserDemo> getUsr() {
		return usr;
	}
	public void setUsr(List<UserDemo> usr) {
		this.usr = usr;
	}

}
