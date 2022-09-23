package com.digitalbook.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BOOK_DETAILS")
public class BookDetails {
	@Id
	  @GenericGenerator(name = "book_id", strategy = "com.digitalbook.generator.BookIdGenerator")
	  @GeneratedValue(generator = "book_id") 
	@Column(name="BOOK_ID")
	private int id;
	@Column(name="TITLE")
	
	@Size(max = 100)
	private String title;
	@Column(name="CATEGORY")
	
	private String category;
	@Column(name="PRICE")
	private float price;
	@Column(name ="PUBLISHER")
	
	private String publisher;
	@Column(name ="BOOK_STATUS")
	private boolean active;
	@Column(nullable = false,name ="CONTENT")
	
	@Size(max = 2000)
	private String content;
	@Column(name = "IMAGE_PATH")
	
	@Size(max = 250)
	private String imagePath;
	@Column(name="RELEASE_DATE")
	private LocalDate releaseDate;
	@Column
	private int authorId;
	@Column
	@Size(max = 100)
	private String authorName;
	@Column(name = "BOOK_BLOCKED")
	private boolean blocked;
	
	
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
