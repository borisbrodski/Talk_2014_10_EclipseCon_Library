package com.github.borisbrodski.ece2014.library.service;

import com.github.borisbrodski.ece2014.library.domain.Author;

public class AuthorConverter {

	public static AuthorDTO convert(Author author) {
		if (author == null) {
			return null;
		}
		AuthorDTO authorDTO = new AuthorDTO();
		authorDTO.setId(author.getId());
		authorDTO.setFirstName(author.getFirstName());
		authorDTO.setLastName(author.getLastName());
		authorDTO.setBirthday(author.getBirthday());
		authorDTO.setDayOfDeath(author.getDayOfDeath());
		return authorDTO;
	}

	public static Author convert(AuthorDTO authorDTO) {
		if (authorDTO == null) {
			return null;
		}
		Author author = new Author();
		author.setId(authorDTO.getId());
		author.setFirstName(authorDTO.getFirstName());
		author.setLastName(authorDTO.getLastName());
		author.setBirthday(authorDTO.getBirthday());
		author.setDayOfDeath(authorDTO.getDayOfDeath());
		return author;
	}

}
