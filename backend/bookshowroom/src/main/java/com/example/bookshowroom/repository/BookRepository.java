package com.example.bookshowroom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshowroom.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByAuthor(String author); //select * from book where author=?
	
	List<Book> findByCategory(String category);
	// select * from book where category=?
	
	List<Book> findByAuthorAndCategory(String author, String category);
	// select * from book where author=? and category=?
	
	List<Book> findByPriceGreaterThan(float price);
	
	List<Book> findByNameContainingIgnoreCase(String title);
}
