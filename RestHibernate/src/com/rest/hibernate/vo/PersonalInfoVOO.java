package com.rest.hibernate.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity
@Table(name="personaldetails")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class PersonalInfoVOO {
	
	@Id
	@Column(name="firstname")
	private String firstName;
	@Column(name="middlename")
	private String middleName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="gender")
	private String gender;
	
	public PersonalInfoVOO(){
		super();
	}
	
	public PersonalInfoVOO(String firstName, String middleName, String lastName, String gender) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PersonalInfoVOO [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", gender=" + gender + "]";
	}

}
