package com.apex.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apex.user.util.HibernateUtil;
import com.apex.user.vo.UserVO;

public class UserDAO {

	public void createUser(UserVO user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(user);
		tx.commit();
		session.close();
	}

	public UserVO getUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UserVO user = (UserVO) session.load(UserVO.class, new Integer(id));
		System.out.println(user);
		session.close();
		return user;

	}

	public void updateUser(UserVO user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.update(user);
		tx.commit();
		session.close();
	}

	public void deleteUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UserVO user = getUser(id);
		Transaction tx = session.getTransaction();
		tx.begin();
		session.delete(user);
		tx.commit();
		session.close();
	}

}
