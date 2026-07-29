package com.example.bookshowroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	private Integer bookId;
	private String name;
	private String author;
	private String category;
	private String imgUrl;
	private Float price;
	private Integer stockCount;
	
	public Book() {
		
	}

	
	

	public Book(Integer bookId, String name, String author, String category, String imgUrl, Float price,
			Integer stockCount) {
		
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.category = category;
		this.imgUrl = imgUrl;
		this.price = price;
		this.stockCount = stockCount;
	}



	public String getCategory() {
		return category;
	}



	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}




	public void setCategory(String category) {
		this.category = category;
	}



	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	
	
}
