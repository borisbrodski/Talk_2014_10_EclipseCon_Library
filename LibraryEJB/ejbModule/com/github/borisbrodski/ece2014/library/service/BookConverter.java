package com.github.borisbrodski.ece2014.library.service;

import java.util.ArrayList;
import java.util.List;

import com.github.borisbrodski.ece2014.library.domain.Book;

public class BookConverter {
	public static BookDTO convert(Book book) {
		if (book == null) {
			return null;
		}
		BookDTO bookDTO = new BookDTO();
		bookDTO.setAuthor(AuthorConverter.convert(book.getAuthor()));
		bookDTO.setGenre(GenreConverter.convert(book.getGenre()));
		bookDTO.setId(book.getId());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setTitle(book.getTitle());
		bookDTO.setRating(book.getRating());
		bookDTO.setMissing(book.getMissing());
		return bookDTO;
	}

	public static Book convert(BookDTO bookDTO) {
		if (bookDTO == null) {
			return null;
		}
		Book book = new Book();
		book.setAuthor(AuthorConverter.convert(bookDTO.getAuthor()));
		book.setGenre(GenreConverter.convert(bookDTO.getGenre()));
		book.setId(bookDTO.getId());
		book.setIsbn(bookDTO.getIsbn());
		book.setTitle(bookDTO.getTitle());
		book.setRating(bookDTO.getRating());
		return book;
	}

	public static List<BookDTO> convertList(List<Book> bookList) {
		List<BookDTO> result = new ArrayList<>();
		for (Book book : bookList) {
			result.add(convert(book));
		}

		return result;
	}
	
}
