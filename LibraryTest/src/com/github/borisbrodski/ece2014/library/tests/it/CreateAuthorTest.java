package com.github.borisbrodski.ece2014.library.tests.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import com.github.borisbrodski.ece2014.library.service.AuthorDTO;
import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;
import com.github.borisbrodski.ece2014.library.testtools.DateTimeTools;
import com.github.borisbrodski.ece2014.library.testtools.ItTestRule;

public class CreateAuthorTest {

	@Rule
	public ItTestRule rule = new ItTestRule();
	
	@Test
	public void canCreateAuthor() throws Exception {
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setFirstName("Jack");
		authorDTO.setLastName("London");
		authorDTO.setBirthday(DateTimeTools.date(1876, 1, 12));
		authorDTO.setDayOfDeath(DateTimeTools.date(1916, 10, 22));

		AuthorDTO persistedAuthorDTO = rule.getLibraryService().createAuthor(
				authorDTO);
		assertNotNull(persistedAuthorDTO);
		assertNotNull(persistedAuthorDTO.getId());
		assertEquals("Jack", persistedAuthorDTO.getFirstName());
		assertEquals("London", persistedAuthorDTO.getLastName());
		assertEquals(DateTimeTools.date(1876, 1, 12),
				persistedAuthorDTO.getBirthday());
		assertEquals(DateTimeTools.date(1916, 10, 22),
				persistedAuthorDTO.getDayOfDeath());
	}

	@Test
	public void canCreateAuthorWithoutBirthday() throws Exception {
		AuthorDTO author = new AuthorDTO();
		author.setFirstName("Jack");
		author.setLastName("London");
		author.setDayOfDeath(DateTimeTools.date(1916, 10, 22));

		try {
			rule.getLibraryService().createAuthor(author);
			Assert.fail("Validatin exception expected");
		} catch (LibraryValidationException exception) {
			Assert.assertEquals("birthday can't be null",
					exception.getMessage());
		}
	}


}
