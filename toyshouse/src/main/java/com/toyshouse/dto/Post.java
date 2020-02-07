package com.toyshouse.dto;

import java.util.Date;

public class Post {
	
	private String title;
	private Date posted;
	private String body;
	private String author;
	
	public Post() {}

	public Post(String title, Date posted, String body, String author) {
		super();
		this.title = title;
		this.posted = posted;
		this.body = body;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", posted=" + posted + ", body=" + body + ", author=" + author + "]";
	}
	

}
