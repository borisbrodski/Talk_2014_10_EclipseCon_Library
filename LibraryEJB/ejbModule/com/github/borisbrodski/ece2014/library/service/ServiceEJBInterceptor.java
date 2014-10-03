package com.github.borisbrodski.ece2014.library.service;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;

public class ServiceEJBInterceptor {

	@PersistenceContext
	private EntityManager entityManager;

	@AroundInvoke
	public Object storeEntityManager(InvocationContext ctx) throws Exception {
		try {
			Thread.sleep(1000);
			EntityManagerTool.setEntityManager(entityManager);
			return ctx.proceed();
		} finally {
			EntityManagerTool.setEntityManager(null);
		}
	}

}
