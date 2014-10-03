package com.github.borisbrodski.ece2014.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book extends AbstractEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String isbn;

	@ManyToOne(optional = false)
	private Author author;
	
	@ManyToOne(optional = false)
	private Genre genre;

	@Column(nullable = false)
	private Integer rating;

	@Column(nullable = false)
	private Boolean missing;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Boolean getMissing() {
		return missing;
	}

	public void setMissing(Boolean missing) {
		this.missing = missing;
	}
}
