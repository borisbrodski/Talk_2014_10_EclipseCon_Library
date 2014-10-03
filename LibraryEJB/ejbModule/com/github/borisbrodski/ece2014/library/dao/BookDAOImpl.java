package com.github.borisbrodski.ece2014.library.dao;

import java.util.List;

import javax.persistence.Query;

import com.github.borisbrodski.ece2014.library.domain.Book;

public class BookDAOImpl extends AbstractDAOImpl<Book> implements BookDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findTopThree() {
		Query query = getEntityManager().createQuery(
				"FROM Book WHERE missing = FALSE ORDER BY rating DESC");
		query.setMaxResults(3);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksForAuthor(Long authorId) {
		Query query = getEntityManager().createQuery(
				"FROM Book WHERE author.id=:authorId");
		query.setParameter("authorId", authorId);
		return query.getResultList();
	}

}
