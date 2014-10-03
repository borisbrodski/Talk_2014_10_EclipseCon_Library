package com.github.borisbrodski.ece2014.library.dao;

import javax.persistence.Query;

import com.github.borisbrodski.ece2014.library.domain.Genre;

public class GenreDAOImpl extends AbstractDAOImpl<Genre> implements GenreDAO {

	@Override
	public Genre findByName(String name) {
		Query query = getEntityManager().createNamedQuery(
				Genre.QUERY_FIND_BY_NAME);
		query.setParameter("name", name);

		return getNullOrSingleResult(query);
	}

}
