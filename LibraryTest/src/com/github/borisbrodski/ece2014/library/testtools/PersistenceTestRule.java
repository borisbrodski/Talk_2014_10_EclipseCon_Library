package com.github.borisbrodski.ece2014.library.testtools;

import javax.persistence.EntityManager;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.github.xfactory.AbstractXFactory;
import org.github.xfactory.XFactory;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PersistenceTestRule extends AbstractTestRule {

	private PersistenceTestStatement statement;

	@Override
	public Statement apply(Statement base, Description description) {
		statement = new PersistenceTestStatement(base);
		return statement;
	}

	public <T, F extends AbstractXFactory<T>> T xpersist(F xfactory) {
		return XFactory.xpersist(xfactory);
	}

	public <T, F extends AbstractXFactory<T>> T xpersist(F xfactory,
			Procedure1<F> initBlock) {
		return XFactory.xpersist(xfactory, initBlock);
	}

	public EntityManager getEntityManager() {
		return statement.getEntityManager();
	}

	public void flush() {
		getEntityManager().flush();
	}

	public void clear() {
		getEntityManager().clear();
	}

	public void resetTransaction() {
		getEntityManager().getTransaction().rollback();
		getEntityManager().getTransaction().begin();
	}
}
