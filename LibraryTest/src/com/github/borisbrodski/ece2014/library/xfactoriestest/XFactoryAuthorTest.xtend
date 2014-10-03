package com.github.borisbrodski.ece2014.library.xfactoriestest

import com.github.borisbrodski.ece2014.library.domain.Author
import com.github.borisbrodski.ece2014.library.testtools.PersistenceTestRule
import com.github.borisbrodski.ece2014.library.xfactories.XFactoryAuthor
import org.junit.Rule
import org.junit.Test

import static org.hamcrest.Matchers.*

class XFactoryGenreTest {
	@Rule
	public extension PersistenceTestRule = new PersistenceTestRule
	
	@Test
	def void buildTest() {
		xbuild(new XFactoryAuthor) => [
			id <=> null
			firstName <=> "John"
			lastName <=> "Doe"
		]
	}

	@Test
	def void persistTest() {
		val author = xpersist(new XFactoryAuthor) => [
			id <=> notNullValue
			firstName <=> "John"
			lastName <=> "Doe"
		]
		
		flush
		clear
		
		entityManager.find(Author, author.id) => [
			it <=> notNullValue
			id <=> author.id
			firstName <=> "John"
			lastName <=> "Doe"
		]
	}
}