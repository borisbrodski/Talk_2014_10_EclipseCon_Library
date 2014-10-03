package com.github.borisbrodski.ece2014.library.tests.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.github.borisbrodski.ece2014.library.service.GenreDTO;
import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;
import com.github.borisbrodski.ece2014.library.testtools.ItTestRule;

public class CreateGenreTest {

	@Rule
	public ItTestRule rule = new ItTestRule();
	
	@Test
	public void canCreateGenre() throws Exception {
		GenreDTO genre = rule.getLibraryService().createGenre(
				"Lyric-" + rule.getSuffix());
		assertNotNull(genre);
		assertNotNull(genre.getId());
		assertEquals("Lyric-" + rule.getSuffix(), genre.getName());
	}

	@Test
	public void twoGenresGetDifferentIds() throws Exception {
		GenreDTO genre1 = rule.getLibraryService().createGenre(
				"Comedy-" + rule.getSuffix());
		GenreDTO genre2 = rule.getLibraryService().createGenre(
				"Drama-" + rule.getSuffix());
		assertFalse(genre1.getId().equals(genre2.getId()));
	}

	@Test
	public void cannotCreateTwoGenresWithSameName() throws Exception {
		rule.getLibraryService().createGenre("Drama-" + rule.getSuffix());

		try {
			rule.getLibraryService().createGenre("Drama-" + rule.getSuffix());
			Assert.fail("LibraryValidationException exception expected");
		} catch (LibraryValidationException exception) {
			assertEquals("Genre 'Drama-" + rule.getSuffix()
					+ "' already exists", exception.getMessage());
		}
	}
}
