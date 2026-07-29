package com.example.bookshowroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshowroom.model.Book;
import com.example.bookshowroom.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Optional<Book> searchBook(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id);
	}

	@Override
	public Book adNewBook(Book newBook) {
		// TODO Auto-generated method stub
		return bookRepo.save(newBook);
	}

	@Override
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
		
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookRepo.findByAuthor(author);
	}

	@Override
	public List<Book> getBooksByPriceGreater(float price) {
		// TODO Auto-generated method stub
		return bookRepo.findByPriceGreaterThan(price);
	}

	@Override
	public List<Book> getBooksByAuthorAndCategory(String author, String category) {
		// TODO Auto-generated method stub
		return bookRepo.findByAuthorAndCategory(author, category);
	}

	@Override
	public List<Book> searchBooksByKeyword(String title) {
		// TODO Auto-generated method stub
		return bookRepo.findByNameContainingIgnoreCase(title);
	}
}
