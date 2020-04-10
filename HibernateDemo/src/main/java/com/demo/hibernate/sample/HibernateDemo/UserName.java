package com.demo.hibernate.sample.HibernateDemo;

import javax.persistence.Embeddable;

@Embeddable
public class UserName {
	
	private String firstname;
	private String lastname;
	private String middlename;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	
	@Override
	public String toString() {
		return "UserName [firstname=" + firstname + ", lastname=" + lastname + ", middlename=" + middlename + "]";
	}

}
