package com.github.borisbrodski.ece2014.library.tests.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;

import com.github.borisbrodski.ece2014.library.service.AuthorDTO;
import com.github.borisbrodski.ece2014.library.service.BookDTO;
import com.github.borisbrodski.ece2014.library.service.GenreDTO;
import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;
import com.github.borisbrodski.ece2014.library.testtools.DateTimeTools;
import com.github.borisbrodski.ece2014.library.testtools.ItTestRule;

public class CreateBookTest {

	@Rule
	public ItTestRule rule = new ItTestRule();

	@Test
	public void canCreateBook() throws Exception {
		AuthorDTO author = createAuthor();
		GenreDTO genre = createGenre();

		BookDTO bookToCreate = new BookDTO();
		bookToCreate.setAuthor(author);
		bookToCreate.setGenre(genre);
		bookToCreate.setTitle("The Case of the Velvet Claws");
		bookToCreate.setIsbn("0884114015");
		bookToCreate.setRating(5);

		author.setFirstName(null);
		author.setLastName(null);
		author.setBirthday(null);
		author.setDayOfDeath(null);

		genre.setName(null);

		BookDTO book = rule.getLibraryService().createBook(bookToCreate);

		assertNotNull(book);
		assertNotNull(book.getId());
		assertEquals("The Case of the Velvet Claws", book.getTitle());
		assertEquals("0884114015", book.getIsbn());


		assertNotNull(book.getAuthor());
		assertEquals(author.getId(), book.getAuthor().getId());

		author = createAuthorDTO();
		assertEquals(author.getBirthday(), book.getAuthor().getBirthday());
		assertEquals(author.getFirstName(), book.getAuthor().getFirstName());
		assertEquals(author.getLastName(), book.getAuthor().getLastName());
		assertEquals(author.getDayOfDeath(), book.getAuthor().getDayOfDeath());

		assertNotNull(book.getGenre());
		assertEquals(genre.getId(), book.getGenre().getId());
		assertEquals("Detective fiction-" + rule.getSuffix(), book.getGenre()
				.getName());
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
