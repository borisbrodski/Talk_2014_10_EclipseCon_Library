package com.github.borisbrodski.ece2014.library.dao;

import com.github.borisbrodski.ece2014.library.domain.Genre;


public interface GenreDAO extends AbstractDAO<Genre> {
	public Genre findByName(String name);
}
