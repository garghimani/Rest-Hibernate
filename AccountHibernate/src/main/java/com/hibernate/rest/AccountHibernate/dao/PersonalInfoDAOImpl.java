package com.hibernate.rest.AccountHibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hibernate.rest.AccountHibernate.util.HibernateUtil;
import com.hibernate.rest.AccountHibernate.validation.AccountValidation;
import com.hibernate.rest.AccountHibernate.validation.AccountValidationException;
import com.hibernate.rest.AccountHibernate.vo.PersonalInfo;

@Repository
public class PersonalInfoDAOImpl implements PersonalInfoDAO {

	public PersonalInfoDAOImpl() {
		super();
	}

	public void addPersonalInfo(PersonalInfo personalVOO) throws AccountValidationException, Exception {

		System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : Start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside addPersonalInfoDAO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validatePersonalDetails(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender()));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + personalVOO.getFirstName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(personalVOO);
			System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : End");
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public PersonalInfo viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		PersonalInfo personalVO = null;
		System.out.println("Inside AccountDAO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + firstName);
			personalVO = (PersonalInfo) session.load(PersonalInfo.class, firstName);
			System.out.println(personalVO);
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return personalVO;
	}

	public void modifyPersonalInfo(PersonalInfo personalVOO) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountDAO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validateFirstName(personalVOO.getFirstName()));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + personalVOO.getFirstName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(personalVOO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountDAO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("DAO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In DAO : " + firstName);
			PersonalInfo personalVO = viewPersonalInfo(firstName);
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(personalVO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
