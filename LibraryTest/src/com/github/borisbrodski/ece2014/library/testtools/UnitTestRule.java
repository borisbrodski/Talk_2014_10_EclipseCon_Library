package com.github.borisbrodski.ece2014.library.testtools;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class UnitTestRule extends AbstractTestRule {

	@Override
	public Statement apply(Statement base, Description description) {
		return new UnitTestStatement(base);
	}

}
