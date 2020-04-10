package com.hibernate.rest.AccountHibernate.dao;


import com.hibernate.rest.AccountHibernate.validation.AccountValidationException;
import com.hibernate.rest.AccountHibernate.vo.PersonalInfo;

public interface PersonalInfoDAO {

	void addPersonalInfo(PersonalInfo personalVOO) throws AccountValidationException, Exception;

	PersonalInfo viewPersonalInfo(String firstName) throws AccountValidationException, Exception;

	void modifyPersonalInfo(PersonalInfo personalVOO) throws AccountValidationException, Exception;

	void deletePersonalInfo(String firstName) throws AccountValidationException, Exception;

}