package com.github.borisbrodski.ece2014.library.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import com.github.borisbrodski.ece2014.library.domain.Author;
import com.github.borisbrodski.ece2014.library.domain.Book;
import com.github.borisbrodski.ece2014.library.domain.Genre;
import com.github.borisbrodski.ece2014.library.domain.LibraryDomain;

/**
 * Main remote service of the Library application.
 */
@Stateless
@Interceptors(ServiceEJBInterceptor.class)
public class LibraryService implements LibraryServiceRemote {

	@Override
	public GenreDTO createGenre(String name) throws LibraryValidationException {
		Genre genre = new LibraryDomain().createGenre(name);
		return GenreConverter.convert(genre);
	}

	@Override
	public AuthorDTO createAuthor(AuthorDTO authorDTO)
			throws LibraryValidationException {
		Author authorToCreate = AuthorConverter.convert(authorDTO);
		Author author = new LibraryDomain().createAuthor(authorToCreate);
		return AuthorConverter.convert(author);
	}

	@Override
	public BookDTO createBook(BookDTO bookDTO)
			throws LibraryValidationException {
		Book bookToCreate = BookConverter.convert(bookDTO);
		Book book = new LibraryDomain().createBook(bookToCreate);
		return BookConverter.convert(book);
	}

	@Override
	public List<BookDTO> getTopThree() {
		return BookConverter.convertList(new LibraryDomain().getTopThree());
	}

	@Override
	public void markBookAsMissing(Long id) throws LibraryValidationException {
		new LibraryDomain().markBookAsMissing(id);
	}

	@Override
	public BookDTO getBook(Long id) {
		return BookConverter.convert(new LibraryDomain().getBook(id));
	}

	@Override
	public Double getAverageRatingPerAuthor(Long authorId) {
		return new LibraryDomain().getAverageRatingPerAuthor(authorId);
	}
}
