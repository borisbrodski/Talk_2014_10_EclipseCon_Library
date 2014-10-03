package com.github.borisbrodski.ece2014.library.service;

import com.github.borisbrodski.ece2014.library.domain.Genre;

public class GenreConverter {

	public static GenreDTO convert(Genre genre) {
		if (genre == null) {
			return null;
		}
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setId(genre.getId());
		genreDTO.setName(genre.getName());
		return genreDTO;
	}

	public static Genre convert(GenreDTO genreDTO) {
		if (genreDTO == null) {
			return null;
		}
		Genre genre = new Genre();
		genre.setId(genreDTO.getId());
		genre.setName(genreDTO.getName());
		return genre;
	}

}
