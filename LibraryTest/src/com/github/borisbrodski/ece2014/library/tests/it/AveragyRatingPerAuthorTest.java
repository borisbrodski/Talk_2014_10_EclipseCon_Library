package com.github.borisbrodski.ece2014.library.tests.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;

import com.github.borisbrodski.ece2014.library.service.AuthorDTO;
import com.github.borisbrodski.ece2014.library.service.BookDTO;
import com.github.borisbrodski.ece2014.library.service.GenreDTO;
import com.github.borisbrodski.ece2014.library.testtools.DateTimeTools;
import com.github.borisbrodski.ece2014.library.testtools.ItTestRule;

public class AveragyRatingPerAuthorTest {

	@Rule
	public ItTestRule rule = new ItTestRule();

	@Test
	public void getAverageRatingOf0BookTest() throws Exception {
		AuthorDTO author = createAuthor();

		Double rating = rule.getLibraryService().getAverageRatingPerAuthor(
				author.getId());
		assertNull(rating);
	}

	@Test
	public void getAverageRatingOf1BookTest() throws Exception {
		AuthorDTO author = createAuthor();
		GenreDTO genre = createGenre();

		createBook(genre, author, "Title 1", 1);

		Double rating = rule.getLibraryService().getAverageRatingPerAuthor(
				author.getId());
		assertEquals(1, rating, 0.00001);
	}

	@Test
	public void getAverageRatingOf5BooksTest() throws Exception {
		AuthorDTO author = createAuthor();
		GenreDTO genre = createGenre();

		List<Integer> ratingList = new ArrayList<>();
		ratingList.add(9);
		ratingList.add(10);
		ratingList.add(3);
		ratingList.add(6);
		ratingList.add(1);

		List<BookDTO> books = new ArrayList<>();
		for (int i = 0; i < ratingList.size(); i++) {
			books.add(createBook(genre, author, "Title " + i, ratingList.get(i)));
		}

		Double rating = rule.getLibraryService().getAverageRatingPerAuthor(
				author.getId());
		assertEquals(calcAverage(ratingList), rating, 0.00001);
	}

	private double calcAverage(List<Integer> ratingList) {
		long sum = 0;
		for (Integer rating : ratingList) {
			sum += rating;
		}
		return ((double) sum) / ratingList.size();
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
