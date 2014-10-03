package com.github.borisbrodski.ece2014.library.test.service;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.Query;

import com.github.borisbrodski.ece2014.library.service.ServiceEJBInterceptor;
import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;

/**
 * Test server if the Library Application. Will not be deployed in production.
 */
@Stateless
@Interceptors(ServiceEJBInterceptor.class)
public class LibraryTestService implements LibraryTestServiceRemote {

	@Override
	public Integer getMaxRating() {
		Query query = EntityManagerTool.getEntityManager().createQuery(
				"SELECT MAX(rating) FROM Book");
		return (Integer) query.getSingleResult();
	}


}
