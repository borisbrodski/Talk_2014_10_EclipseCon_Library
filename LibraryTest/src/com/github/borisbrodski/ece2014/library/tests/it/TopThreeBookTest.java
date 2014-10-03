package com.github.borisbrodski.ece2014.library.tests.it;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import com.github.borisbrodski.ece2014.library.service.AuthorDTO;
import com.github.borisbrodski.ece2014.library.service.BookDTO;
import com.github.borisbrodski.ece2014.library.service.GenreDTO;
import com.github.borisbrodski.ece2014.library.testtools.DateTimeTools;
import com.github.borisbrodski.ece2014.library.testtools.ItTestRule;

public class TopThreeBookTest {

	@Rule
	public ItTestRule rule = new ItTestRule();

	@Test
	public void getTopThreeBooksTest() throws Exception {
		int max = getMaxRating();

		AuthorDTO author = createAuthor();
		GenreDTO genre = createGenre();

		List<BookDTO> books = new ArrayList<>();
		books.add(createBook(genre, author, "Title 1", max + 9));
		books.add(createBook(genre, author, "Title 2", max + 10));
		books.add(createBook(genre, author, "Title 3", max + 3));
		books.add(createBook(genre, author, "Title 4", max + 6));
		books.add(createBook(genre, author, "Title 5", max + 1));

		List<BookDTO> topThree = rule.getLibraryService().getTopThree();
		assertEquals(3, topThree.size());
		assertEquals(books.get(1).getId(), topThree.get(0).getId());
		assertEquals(books.get(0).getId(), topThree.get(1).getId());
		assertEquals(books.get(3).getId(), topThree.get(2).getId());
	}

	@Test
	public void topThreeBooksIgnoresMissed() throws Exception {
		int max = getMaxRating();

		AuthorDTO author = createAuthor();
		GenreDTO genre = createGenre();

		List<BookDTO> books = new ArrayList<>();
		books.add(createBook(genre, author, "Title 2", max + 9));
		books.add(createBook(genre, author, "Title 1", max + 10));
		books.add(createBook(genre, author, "Title 4", max + 3));
		books.add(createBook(genre, author, "Title 3", max + 6));
		books.add(createBook(genre, author, "Title 5", max + 1));

		rule.getLibraryService().markBookAsMissing(books.get(0).getId());
		List<BookDTO> topThree = rule.getLibraryService().getTopThree();
		assertEquals(3, topThree.size());
		assertEquals(books.get(1).getId(), topThree.get(0).getId());
		assertEquals(books.get(3).getId(), topThree.get(1).getId());
		assertEquals(books.get(2).getId(), topThree.get(2).getId());
	}

	@Test
	public void TopThreeReturnsJustOneBook() throws Exception {
		// How we tests it without marking all books as missing?
	}

	private int getMaxRating() {
		Integer max = rule.getLibraryTestService().getMaxRating();
		if (max == null) {
			return 0;
		}
		return max;
	}

	private BookDTO createBook(GenreDTO genre, AuthorDTO author, String title,
			int rating) throws Exception {
		BookDTO bookToCreate = new BookDTO();
		bookToCreate.setAuthor(author);
		bookToCreate.setGenre(genre);
		bookToCreate.setTitle(title);
		bookToCreate.setIsbn("000000000" + rating);
		bookToCreate.setRating(rating);

		return rule.getLibraryService().createBook(bookToCreate);
	}

	private GenreDTO createGenre() throws Exception {
		return rule.getLibraryService().createGenre(
				"Detective fiction-" + rule.getSuffix());
	}

	private AuthorDTO createAuthor() throws Exception {
		AuthorDTO authorDTO1 = new AuthorDTO();
		authorDTO1.setFirstName("Erle Stanley-" + rule.getSuffix());
		authorDTO1.setLastName("Gardner-" + rule.getSuffix());
		authorDTO1.setBirthday(DateTimeTools.date(1889, 7, 17));
		authorDTO1.setDayOfDeath(DateTimeTools.date(1970, 3, 11));
		AuthorDTO authorDTO = authorDTO1;
		return rule.getLibraryService().createAuthor(authorDTO);
	}

}
