package com.demo.hibernate.sample.HibernateDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure().addAnnotatedClass(UserDemo.class)
				.addAnnotatedClass(Courses.class);

		org.hibernate.service.ServiceRegistry serviceReg = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();

		SessionFactory sessionFactory = config.buildSessionFactory(serviceReg);

		Session session1 = sessionFactory.openSession();

		// Transaction tx1 = session1.beginTransaction();
		session1.beginTransaction();

		/*
		 * 
		 * 
		 * INSERT data in database
		 * 
		 * 
		 */

		/*
		 * for (int i = 1; i <= 10; i++) { UserName uName = new UserName(); UserDemo
		 * user = new UserDemo(); Courses course = new Courses();
		 * 
		 * uName.setFirstname("Test" + i); uName.setLastname("Test" + i);
		 * uName.setMiddlename("Test" + i);
		 * 
		 * user.setId(i); user.setName(uName); user.setTitle("Student" + i);
		 * user.getCourse().add(course);
		 * 
		 * course.setRollNo(100 + i); course.setCourseName("Course"+i);
		 * course.getUsr().add(user);
		 * 
		 * session1.save(user); session1.save(course); }
		 */

		/*
		 * 
		 * RETRIEVE data.
		 * 
		 * 
		 */

		// user = (UserDemo) session1.get(UserDemo.class, 1);

		UserDemo user = new UserDemo();
		Courses course = new Courses();
		
		int userId = 5;

		Query query1 = session1.createQuery("from UserDemo where id > :userId");
		query1.setParameter("userId", userId);
		query1.setCacheable(true);
		@SuppressWarnings("unchecked")
		List<UserDemo> user_q1 = query1.list();
		for (UserDemo user_data : user_q1) {
			System.out.println(user_data);
		}

		// tx1.commit();
		session1.getTransaction().commit();
		session1.close();

		/*
		 * Session session2 = sessionFactory.openSession();
		 * 
		 * session2.beginTransaction(); // user = (UserDemo)
		 * session2.get(UserDemo.class, 1);
		 * 
		 * Query query2 = session2.createQuery("from UserDemo");
		 * query2.setCacheable(true);
		 * 
		 * user = (UserDemo)query2.uniqueResult(); --Used to retrieve single record
		 * System.out.println(user);
		 * 
		 * 
		 * session2.getTransaction().commit(); session2.close();
		 */

	}
}
