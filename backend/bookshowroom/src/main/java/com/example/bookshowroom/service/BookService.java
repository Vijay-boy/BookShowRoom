package com.example.bookshowroom.service;

import java.util.List;
import java.util.Optional;

import com.example.bookshowroom.model.Book;

public interface BookService {

	List<Book> getAllBook();
	
	Optional<Book> searchBook(int id);
	
	Book adNewBook(Book newBook);
	
	void deleteBook(int id);
	
	List<Book> getBooksByAuthor(String author);
	
	List<Book> getBooksByPriceGreater(float price);
	
	List<Book> getBooksByAuthorAndCategory(String author, String category);
	
	List<Book> searchBooksByKeyword(String title);
}
