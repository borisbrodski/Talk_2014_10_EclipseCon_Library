package com.github.borisbrodski.ece2014.library.tests.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;

import com.github.borisbrodski.ece2014.library.service.AuthorDTO;
import com.github.borisbrodski.ece2014.library.service.BookDTO;
import com.github.borisbrodski.ece2014.library.service.GenreDTO;
import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;
import com.github.borisbrodski.ece2014.library.testtools.DateTimeTools;
import com.github.borisbrodski.ece2014.library.testtools.ItTestRule;

public class BookMarkMissingTest {

	@Rule
	public ItTestRule rule = new ItTestRule();

	@Test
	public void markBookAsMissing() throws Exception {
		BookDTO bookToCreate = createBook();

		BookDTO book = rule.getLibraryService().createBook(bookToCreate);

		assertFalse(book.getMissing());
		rule.getLibraryService().markBookAsMissing(book.getId());

		BookDTO missingBook = rule.getLibraryService().getBook(book.getId());

		assertNotNull(missingBook);
		assertEquals(book.getId(), missingBook.getId());
		assertTrue(missingBook.getMissing());
	}

	@Test
	public void markMissedBookAsMissing() throws Exception {
		BookDTO bookToCreate = createBook();
		BookDTO book = rule.getLibraryService().createBook(bookToCreate);

		rule.getLibraryService().markBookAsMissing(book.getId());
		try {
			rule.getLibraryService().markBookAsMissing(book.getId());
			fail("Exception expected");
		} catch (LibraryValidationException exception) {
			assertEquals("Book already marked as missing",
					exception.getMessage());
		}
	}

	private BookDTO createBook() throws LibraryValidationException {
		AuthorDTO author = createAuthor();
		GenreDTO genre = createGenre();

		BookDTO bookToCreate = new BookDTO();
		bookToCreate.setAuthor(author);
		bookToCreate.setGenre(genre);
		bookToCreate.setTitle("The Case of the Velvet Claws");
		bookToCreate.setIsbn("0884114015");
		bookToCreate.setRating(5);
		return bookToCreate;
	}

	private GenreDTO createGenre() throws LibraryValidationException {
		return rule.getLibraryService().createGenre(
				"Detective fiction-" + rule.getSuffix());
	}

	private AuthorDTO createAuthor() throws LibraryValidationException {
		AuthorDTO authorDTO = createAuthorDTO();
		return rule.getLibraryService().createAuthor(authorDTO);
	}

	private AuthorDTO createAuthorDTO() {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setFirstName("Erle Stanley-" + rule.getSuffix());
		authorDTO.setLastName("Gardner-" + rule.getSuffix());
		authorDTO.setBirthday(DateTimeTools.date(1889, 7, 17));
		authorDTO.setDayOfDeath(DateTimeTools.date(1970, 3, 11));
		return authorDTO;
	}

}
