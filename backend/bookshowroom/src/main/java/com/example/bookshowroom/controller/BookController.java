package com.example.bookshowroom.controller;

import java.util.List;
import java.util.Optional;
import com.example.bookshowroom.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshowroom.model.Book;
import com.example.bookshowroom.service.BookService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class BookController {

    private final BookServiceImpl bookServiceImpl;

	@Autowired
	private BookService bookService;

    BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }
	
	@GetMapping("/api/books")
	public List<Book> apiForGetBooks(){
		return bookService.getAllBook();
	}
	
	@GetMapping("/api/books/{id}")
	public Optional<Book> apiForSearchBook(@PathVariable int id){
		Optional<Book> opt=bookService.searchBook(id);
		if(opt.isEmpty())
			return Optional.ofNullable(new Book());
		return opt;
	}
	
	//localhost:8081/api/filter/books?author=Stepen
	@GetMapping("/api/books/filter")
	public List<Book> apiForBooksByAuthor(@RequestParam String author)
	{
		return bookService.getBooksByAuthor(author);
	}
	
	@GetMapping("/api/books/price-filter")
	public List<Book> apiForBooksByPrice(@RequestParam float price)
	{
		return bookService.getBooksByPriceGreater(price);
	}
	
	//localhost:8081/api/books/book-filter?author=Stepen&category=Non Fiction
	@GetMapping("/api/books/book-filter")
	public List<Book> apiForBooksByAuthorCategory(@RequestParam String author, @RequestParam String category)
	{
		return bookService.getBooksByAuthorAndCategory(author, category);
	}
	
	@GetMapping("/api/books/search")
	public List<Book> apiForSearchBooks(@RequestParam String title)
	{
		return bookService.searchBooksByKeyword(title);
	}
	
	@PostMapping("/api/books")
	public Book apiForAddBook(@RequestBody Book book)
	{
		Optional<Book> opt=bookService.searchBook(book.getBookId());
		if(opt.isEmpty())
			return bookService.adNewBook(book);
		
		return new Book();
	}
	
	@PutMapping("/api/books/{id}")
	public Book apiForEditBook(@PathVariable int id, @RequestBody Book book)
	{
		Optional<Book> opt=bookService.searchBook(id);
		if(opt.isPresent())
			return bookService.adNewBook(book);
		
		return new Book();
	}
	
	@DeleteMapping("/api/books/{id}")
	public Optional<Book> apiForDeleteBook(@PathVariable int id)
	{
		Optional<Book> opt=bookService.searchBook(id);
		if(opt.isPresent())
		{
			bookService.deleteBook(id);
			return opt;
		}
		return opt;
	}
}
