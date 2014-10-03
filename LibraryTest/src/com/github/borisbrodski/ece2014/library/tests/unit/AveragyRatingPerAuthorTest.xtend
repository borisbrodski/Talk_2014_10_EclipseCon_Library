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
		
		new LibraryDomain().getAverageRatingPerAuthor(5L) <=> 2.0
	}
}
