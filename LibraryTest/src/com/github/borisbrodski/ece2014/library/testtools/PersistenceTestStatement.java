package com.github.borisbrodski.ece2014.library.testtools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.github.xfactory.InfrastructureProvider;
import org.github.xfactory.XFactory;
import org.junit.runners.model.Statement;

import com.github.borisbrodski.ece2014.library.tools.EntityManagerTool;

public class PersistenceTestStatement extends Statement implements
		InfrastructureProvider {

	private Statement base;
	private static EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public PersistenceTestStatement(Statement base) {
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		boolean ok = false;
		try {
			initEntityManager();
			beginTransaction();
			XFactory.initTest(this);
			base.evaluate();
			ok = true;
		} finally {
			XFactory.doneTest();
			try {
				rollbackTransaction();
			} catch (Throwable e) {
				if (ok) {
					ok = false;
					throw e;
				} else {
					e.printStackTrace();
				}
			} finally {
				try {
					closeEntityManager();
				} catch (Throwable e) {
					if (ok) {
						throw e;
					} else {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void beginTransaction() {
		if (entityManager != null) {
			entityManager.getTransaction().begin();
		}
	}

	private void rollbackTransaction() {
		if (entityManager != null) {
			entityManager.getTransaction().rollback();
		}
	}

	private void closeEntityManager() {
		if (entityManager != null) {
			entityManager.close();
		}
		EntityManagerTool.setEntityManager(null);
	}

	private void initEntityManager() {
		entityManager = getEntityManagerFactory().createEntityManager();
		EntityManagerTool.setEntityManager(entityManager);
	}

	private synchronized EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence
					.createEntityManagerFactory("testset1");
		}
		return entityManagerFactory;
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
