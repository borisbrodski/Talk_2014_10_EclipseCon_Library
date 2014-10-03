package com.github.borisbrodski.ece2014.library.xfactoriestest

import com.github.borisbrodski.ece2014.library.domain.Book
import com.github.borisbrodski.ece2014.library.testtools.PersistenceTestRule
import com.github.borisbrodski.ece2014.library.xfactories.XFactoryBook
import org.junit.Rule
import org.junit.Test

import static org.hamcrest.Matchers.*

class XFactoryBookTest {
	@Rule
	public extension PersistenceTestRule = new PersistenceTestRule
	
	@Test
	def void buildTest() {
		xbuild(new XFactoryBook) => [
			id <=> null
			title <=> "Eclipse Plug-ins"
		]
	}

	@Test
	def void persistTest() {
		val book = xpersist(new XFactoryBook) => [
			id <=> notNullValue
			title <=> "Eclipse Plug-ins"
		]
		
		flush
		clear
		
		entityManager.find(Book, book.id) => [
			it <=> notNullValue
			id <=> book.id
			title <=> book.title
			genre.name <=> book.genre.name
			author.firstName <=> book.author.firstName
		]
	}
}