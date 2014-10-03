package com.github.borisbrodski.ece2014.library.tools;

import javax.persistence.EntityManager;

public class EntityManagerTool {
	private static ThreadLocal<EntityManager> entityManagerThreadLocal = new ThreadLocal<EntityManager>();
	
	public static EntityManager getEntityManager() {
		return entityManagerThreadLocal.get();
	}
	
	public static void setEntityManager(EntityManager entityManager) {
		entityManagerThreadLocal.set(entityManager);
	}
}
