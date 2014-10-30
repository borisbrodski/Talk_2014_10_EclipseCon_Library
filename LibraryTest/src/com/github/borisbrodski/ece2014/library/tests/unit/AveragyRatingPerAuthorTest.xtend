package com.github.borisbrodski.ece2014.library.tests.unit

import com.github.borisbrodski.ece2014.library.dao.BookDAOImpl
import com.github.borisbrodski.ece2014.library.testtools.UnitTestRule
import mockit.Mocked
import org.junit.Rule
import org.junit.Test
import static extension org.eclipse.xtend.jmockit.JMockitExtension.*
import com.github.borisbrodski.ece2014.library.xfactories.XFactoryBook
import com.github.borisbrodski.ece2014.library.domain.LibraryDomain

class AveragyRatingPerAuthorTest {
	@Rule
	public extension UnitTestRule = new UnitTestRule

	@Mocked
	BookDAOImpl bookDAO

	@Test
	def void twoBooksTest() {
		val books = #[
			xbuild(new XFactoryBook) [
				minimal
				set [
					rating = 1
				]
			],
			xbuild(new XFactoryBook) [
				minimal
				set [
					rating = 3
				]
			]
		]
		
		stub [
			bookDAO.getBooksForAuthor(5L)
			result = books
		]
		
		
		new LibraryDomain().getAverageRatingPerAuthor(5L) <=> 2.0
	}
}
