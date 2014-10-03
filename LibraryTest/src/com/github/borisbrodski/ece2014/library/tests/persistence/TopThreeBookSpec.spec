package com.github.borisbrodski.ece2014.library.tests.persistence

import com.github.borisbrodski.ece2014.library.dao.BookDAOImpl
import com.github.borisbrodski.ece2014.library.testtools.PersistenceTestRule
import com.github.borisbrodski.ece2014.library.xfactories.XFactoryBook
import org.junit.Rule

describe "Top three books" {
	@Rule
	public extension PersistenceTestRule = new PersistenceTestRule

	fact "Can find top three books" {
	
		new BookDAOImpl().findTopThree() should be #[]
	}
}
