package com.rest.demo.RestDemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rest.demo.RestDemo.util.HibernateUtil;
import com.rest.demo.RestDemo.vo.Books;

public class BooksRepository {

	private List<Books> booklist;
	private Books getbook;

	public BooksRepository() {
		super();
		// book = new ArrayList<>();

		/*
		 * Books book1 = new Books(); book1.setBookid(11); book1.setBookName("Demo");
		 * book1.setAuthor("Test"); book1.setCategory("ABC"); book1.setNoOfCopies(2);
		 * 
		 * Books book2 = new Books(); book2.setBookid(10); book2.setBookName("Demo1");
		 * book2.setAuthor("Test1"); book2.setCategory("ABC1"); book2.setNoOfCopies(2);
		 * 
		 * book.add(book1); book.add(book2);
		 */
	}

	@SuppressWarnings("unchecked")
	public List<Books> getBooks() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			booklist = session.createCriteria(Books.class).list();
			return booklist;
		} catch (Exception e) {
			System.out.println("Inside getBooks Exception....");
			return new ArrayList<>();
		}
	}

	public Books getBook(int bookid) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			getbook = (Books) session.load(Books.class, new Integer(bookid));
			System.out.println(getbook);
			return getbook;
		} catch (Exception e) {
			System.out.println("Inside getBook exception..");
			return new Books();
		}

		/*
		 * for (Books b : book) { if (b.getBookid() == id) return new Books();
		 * 
		 * }
		 * 
		 * return book1;
		 */
	}

	public void createBook(Books book) {
		// book.add(book2);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(book);
		tx.commit();
		session.close();

	}

	public void updateBooks(Books book) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();
		session.update(book);
		tx.commit();
		session.close();

	}

	public void deleteBooks(int bookid) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Books book = getBook(bookid);
		Transaction tx = session.getTransaction();
		tx.begin();
		session.delete(book);
		tx.commit();
		session.close();

	}

}
