package com.github.borisbrodski.ece2014.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.github.borisbrodski.ece2014.library.dao.DAO;
import com.github.borisbrodski.ece2014.library.dao.GenreDAO;
import com.github.borisbrodski.ece2014.library.service.LibraryValidationException;

@Entity
@NamedQuery(name = Genre.QUERY_FIND_BY_NAME, query = "FROM Genre g WHERE g.name=:name")
public class Genre extends AbstractEntity {
	public static final String QUERY_FIND_BY_NAME = "Genre.findByName";
	
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Override
	public void validate() throws LibraryValidationException {
		Genre genre = DAO.get(GenreDAO.class).findByName(name);
		if (genre != null && !genre.getId().equals(id)) {
			throw new LibraryValidationException("Genre '" + name
					+ "' already exists");
		}
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
