package com.rest.demo.RestDemo.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="books")
public class Books {
	
	@Id
	@Column(name="bookid")
	private int bookid;
	@Column(name="bookName")
	private String bookName;
	@Column(name="author")
	private String author;
	@Column(name="category")
	private String category;
	@Column(name="noOfCopies")
	private int noOfCopies;

	public Books() {
		super();
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", bookName=" + bookName + ", author=" + author + ", category=" + category
				+ ", noOfCopies=" + noOfCopies + "]";
	}

}
