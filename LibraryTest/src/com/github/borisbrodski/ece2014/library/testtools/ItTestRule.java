package com.github.borisbrodski.ece2014.library.testtools;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.github.borisbrodski.ece2014.library.service.LibraryServiceRemote;
import com.github.borisbrodski.ece2014.library.test.service.LibraryTestServiceRemote;

public class ItTestRule extends AbstractTestRule {

	private ItTestStatement itTestStatement;
	private LibraryServiceRemote libraryService;
	private LibraryTestServiceRemote libraryTestService;

	@Override
	public Statement apply(Statement base, Description description) {
		libraryService = CommonTestTools.getService(LibraryServiceRemote.class);
		libraryTestService = CommonTestTools
				.getService(LibraryTestServiceRemote.class);

		itTestStatement = new ItTestStatement(base);
		return itTestStatement;
	}

	public LibraryServiceRemote getLibraryService() {
		return libraryService;
	}

	public LibraryTestServiceRemote getLibraryTestService() {
		return libraryTestService;
	}
}
