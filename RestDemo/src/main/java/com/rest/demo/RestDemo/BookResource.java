package com.rest.demo.RestDemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.demo.RestDemo.repository.BooksRepository;
import com.rest.demo.RestDemo.vo.Books;

@Path("books")
public class BookResource {

	BooksRepository bookRepo = new BooksRepository();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Books> getBooks() {

		return bookRepo.getBooks();

	}

	@GET
	@Path("getBook/{bookid}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Books getBook(@PathParam("bookid") int bookid) {
		System.out.println("Inside getBook....");
		return bookRepo.getBook(bookid);
	}

	@POST
	@Path("createBook")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Books createBooks(Books book) {
		System.out.println("Inside createBooks...");
		bookRepo.createBook(book);

		return book;
	}

	@PUT
	@Path("updateBook")
	public Books updateBooks(Books book) {
		System.out.println("Inside createBooks...");
		if (bookRepo.getBook(book.getBookid()).getBookid() == 0) {
			bookRepo.createBook(book);
		} else {
			bookRepo.updateBooks(book);
		}

		return book;
	}

	@DELETE
	@Path("deleteBook/{bookid}")
	public void deleteBooks(@PathParam("bookid") int bookid) {
		System.out.println("Inside createBooks...");
		Books book = bookRepo.getBook(bookid);
		if (book.getBookid() != 0)
			bookRepo.deleteBooks(bookid);

	}

}
