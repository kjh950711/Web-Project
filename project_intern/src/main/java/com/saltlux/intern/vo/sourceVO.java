package com.saltlux.intern.vo;

public class sourceVO {
	
	private int title;
	private int author;
	private int publisher;
	private int year;
	
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getPublisher() {
		return publisher;
	}
	public void setPublisher(int publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "sourceVO [title=" + title + ", author=" + author + ", publisher=" + publisher + ", year=" + year + "]";
	}
	
	
}
