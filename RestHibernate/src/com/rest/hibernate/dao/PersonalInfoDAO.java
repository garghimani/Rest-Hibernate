package com.rest.hibernate.dao;


import com.rest.hibernate.validation.AccountValidationException;
import com.rest.hibernate.vo.PersonalInfoVOO;

public interface PersonalInfoDAO {

	void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception;

	PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception;

	void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception;

	void deletePersonalInfo(String firstName) throws AccountValidationException, Exception;

}