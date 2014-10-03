package com.github.borisbrodski.ece2014.library.dao;

import java.util.List;

import com.github.borisbrodski.ece2014.library.domain.Book;

public interface BookDAO extends AbstractDAO<Book> {
	/**
	 * Find top 3 rated books
	 * 
	 * @return up to 3 books
	 */
	public List<Book> findTopThree();

	/**
	 * Get all books of the author <code>author</code>
	 * 
	 * @param authorId
	 *            If of the author
	 * @return list of the books
	 */
	public List<Book> getBooksForAuthor(Long authorId);
}
