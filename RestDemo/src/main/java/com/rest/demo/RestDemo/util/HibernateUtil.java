package com.rest.demo.RestDemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.rest.demo.RestDemo.vo.Books;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static Configuration config;

	// Create the initial SessionFactory from the default configuration files
	static {
		try {
			config = new Configuration().configure().addAnnotatedClass(Books.class);

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
