package com.action;

import java.sql.Date;

public class Book {
	private String Tiltle;
	private String ISBN;
	private String publisher;
	private Date   publishDate;
	private double price;
	private Author author;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTiltle() {
		return Tiltle;
	}
	public void setTiltle(String tiltle) {
		Tiltle = tiltle;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
