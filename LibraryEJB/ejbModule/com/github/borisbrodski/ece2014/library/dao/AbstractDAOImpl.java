package com.github.borisbrodski.ece2014.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.github.borisbrodski.ece2014.library.domain.AbstractEntity;
import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;

public class AbstractDAOImpl<T extends AbstractEntity> implements
		AbstractDAO<T> {
	protected EntityManager getEntityManager() {
		return EntityManagerTool.getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public <T1> T1 getNullOrSingleResult(Query query) {
		List<T1> resultList = query.getResultList();
		switch (resultList.size()) {
		case 0:
			return null;
		case 1:
			return resultList.get(0);
		default:
			throw new RuntimeException("Single result expected. Get results: "
					+ resultList.size());
		}
	}
}
