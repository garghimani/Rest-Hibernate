package com.hibernate.rest.AccountHibernate;

import com.hibernate.rest.AccountHibernate.dao.PersonalInfoDAO;
import com.hibernate.rest.AccountHibernate.dao.PersonalInfoDAOImpl;
import com.hibernate.rest.AccountHibernate.validation.AccountValidationException;
import com.hibernate.rest.AccountHibernate.vo.PersonalInfo;

/**
 * Hello world!
 *
 */
public class AccountResource 
{
	
	 static PersonalInfoDAO personalDAO = new PersonalInfoDAOImpl();
	 static PersonalInfo personalVO = new PersonalInfo();
	 
    public static void main( String[] args ) throws AccountValidationException, Exception
    {
        System.out.println( "Hello World!" ); 
        
        personalDAO.addPersonalInfo(personalVO);
        personalDAO.viewPersonalInfo(personalVO.getFirstName());
        personalDAO.modifyPersonalInfo(personalVO);
        personalDAO.deletePersonalInfo(personalVO.getFirstName());
        
    }   
    
}
