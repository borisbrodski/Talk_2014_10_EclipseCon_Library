package com.github.borisbrodski.ece2014.library.domain;

import java.util.List;

import com.github.borisbrodski.ece2014.library.dao.BookDAO;
import com.github.borisbrodski.ece2014.library.dao.DAO;
import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;
import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;

public class LibraryDomain {

	public Genre createGenre(String name) throws LibraryValidationException {
		Genre genre = new Genre();
		genre.setName(name);
		genre.persist();
		return genre;
	}

	public Author createAuthor(Author author) throws LibraryValidationException {
		author.persist();
		return author;
	}

	public Book createBook(Book book) throws LibraryValidationException {
		book.setMissing(false);
		book.persist();
		EntityManagerTool.getEntityManager().flush();
		book.refresh();
		return book;
	}

	public List<Book> getTopThree() {
		return DAO.get(BookDAO.class).findTopThree();
	}

	public Book getBook(Long id) {
		return DAO.getEntity(Book.class, id);
	}

	public void markBookAsMissing(Long id) throws LibraryValidationException {
		Book book = DAO.getEntity(Book.class, id);
		if (book.getMissing()) {
			throw new LibraryValidationException(
					"Book already marked as missing");
		}
		book.setMissing(true);
	}

	public Double getAverageRatingPerAuthor(Long authorId) {
		// PRETEND, that average can't be calculated within a query!

		// Not using mappedBy attribute for demonstration purposes
		// THIS WILL BE MOCKED
		List<Book> books = DAO.get(BookDAO.class).getBooksForAuthor(authorId);

		if (books.size() == 0) {
			return null;
		}

		long sum = 0;
		for (Book book : books) {
			sum += book.getRating();
		}

		return ((double) sum) / books.size();
	}
}
