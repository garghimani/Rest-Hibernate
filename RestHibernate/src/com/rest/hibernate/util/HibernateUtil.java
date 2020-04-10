package com.rest.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rest.hibernate.vo.PersonalInfoVOO;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static Configuration config;

	// Create the initial SessionFactory from the default configuration files
	static {
		try {
			config = new Configuration().configure().addAnnotatedClass(PersonalInfoVOO.class);
			/*
			 * .addAnnotatedClass(AccountVOO.class).addAnnotatedClass(ContactInfoVOO.class)
			 * .addAnnotatedClass(BankInfoVOO.class);
			 */

			org.hibernate.service.ServiceRegistry serviceReg = new ServiceRegistryBuilder()
					.applySettings(config.getProperties()).buildServiceRegistry();

			sessionFactory = config.buildSessionFactory(serviceReg);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
