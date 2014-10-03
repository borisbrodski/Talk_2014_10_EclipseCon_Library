package com.github.borisbrodski.ece2014.library.service;

public class BookDTO extends AbstractDTO {
	private static final long serialVersionUID = 42L;

	private Long id;

	private String title;

	private String isbn;

	private AuthorDTO author;

	private GenreDTO genre;

	private Integer rating;

	private Boolean missing;

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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getRating() {
		return rating;
	}

	public void setMissing(boolean missing) {
		this.missing = missing;
	}
	public Boolean getMissing() {
		return missing;
	}
}
