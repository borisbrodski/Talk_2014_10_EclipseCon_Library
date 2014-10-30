package com.github.borisbrodski.ece2014.library.tests.persistence

import com.github.borisbrodski.ece2014.library.dao.BookDAOImpl
import com.github.borisbrodski.ece2014.library.testtools.PersistenceTestRule
import com.github.borisbrodski.ece2014.library.xfactories.XFactoryBook
import org.junit.Rule

describe "Top three books" {
	@Rule
	public extension PersistenceTestRule = new PersistenceTestRule

	def data{
		| ratings       | indexes    |
		| #[4]          | #[0]       |
		| #[6, 3, 8, 1] | #[2, 0, 1] |
	}

	fact "Can find top three books" {
		data.forEach[
			resetTransaction
			val books = ratings.map [ r |
				xpersist(new XFactoryBook) [
					minimal
					set [
						rating = r
					]
				]
			].immutableCopy
	
			new BookDAOImpl().findTopThree() should be indexes.map[i|books.get(i)]
		]
	}
}
