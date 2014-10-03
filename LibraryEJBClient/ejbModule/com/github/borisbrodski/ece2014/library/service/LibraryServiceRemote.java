package com.github.borisbrodski.ece2014.library.service;

import java.util.List;

import javax.ejb.Remote;

/**
 * Remove interface to the library app.
 * 
 * @author Boris Brodski
 *
 */
@Remote
public interface LibraryServiceRemote {
	/**
	 * Creates a new genre.
	 * 
	 * @param name new genre to create
	 * @return created genre
	 * @throws LibraryValidationException on validation errors
	 */
	public GenreDTO createGenre(String name) throws LibraryValidationException;

	/**
	 * Creates a new author.
	 * 
	 * @param authorDTO new author to create
	 * @return created author
	 * @throws LibraryValidationException on validation errors
	 */
	public AuthorDTO createAuthor(AuthorDTO authorDTO) throws LibraryValidationException;

	/**
	 * Creates a new book.
	 * 
	 * @param bookDTO book to create
	 * @return created book
	 * @throws LibraryValidationException on validation errors
	 */
	public BookDTO createBook(BookDTO bookDTO) throws LibraryValidationException;

	/**
	 * Returns top three rated (non missed) books.
	 * 
	 * @return a list of three or less elements
	 */
	public List<BookDTO> getTopThree();

	/**
	 * Mark book as missing
	 * @param id Book id
	 * @throws LibraryValidationException if book was already marked as missing
	 */
	public void markBookAsMissing(Long id) throws LibraryValidationException;

	/**
	 * Fetch Book
	 * @param id Book id
	 * @return Book with id <code>id</code>
	 */
	public BookDTO getBook(Long id);

	/**
	 * Calculate average rating over all books of the author.
	 * 
	 * @param authorId id of the author
	 * @return average rating or <code>null</code> if the author has no books
	 */
	public Double getAverageRatingPerAuthor(Long authorId);
}
