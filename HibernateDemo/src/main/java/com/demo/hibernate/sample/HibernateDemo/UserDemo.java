package com.demo.hibernate.sample.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="user_demo")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class UserDemo {
	
	// Use @Transient to store temporary data . This column is not created in the database
	@Id
	private int id;
	private UserName name;
	@Column(name="job_title")
	private String title;
	
	@ManyToMany(mappedBy="usr")
	private List<Courses> course = new ArrayList<Courses>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public UserName getName() {
		return name;
	}
	public void setName(UserName name) {
		this.name = name;
	}		
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "UserDemo [id=" + id + ", name=" + name + ", title=" + title + "]";
	}
	public List<Courses> getCourse() {
		return course;
	}
	public void setCourse(List<Courses> course) {
		this.course = course;
	}
	
}
