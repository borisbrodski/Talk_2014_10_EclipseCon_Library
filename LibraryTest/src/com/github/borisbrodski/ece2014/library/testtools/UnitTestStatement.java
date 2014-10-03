package com.github.borisbrodski.ece2014.library.testtools;

import org.junit.runners.model.Statement;

public class UnitTestStatement extends Statement {

	private Statement base;

	public UnitTestStatement(Statement base) {
		this.base = base;
	}

	@Override
	public void evaluate() throws Throwable {
		base.evaluate();
	}

}
