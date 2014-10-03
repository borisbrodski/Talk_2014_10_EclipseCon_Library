package com.github.borisbrodski.ece2014.library.xfactoriestest

import com.github.borisbrodski.ece2014.library.testtools.PersistenceTestRule
import com.github.borisbrodski.ece2014.library.xfactories.XFactoryGenre
import org.junit.Rule
import org.junit.Test

import static org.hamcrest.Matchers.*
import com.github.borisbrodski.ece2014.library.domain.Genre

class XFactoryGenreTest {
	@Rule
	public extension PersistenceTestRule = new PersistenceTestRule
	
	@Test
	def void buildTest() {
		xbuild(new XFactoryGenre) => [
			id <=> null
			name.startsWith("Drama") <=> true
		]
	}

	@Test
	def void persistTest() {
		val genre = xpersist(new XFactoryGenre) => [
			id <=> notNullValue
			name.startsWith("Drama") <=> true
		]
		
		flush
		clear
		
		entityManager.find(Genre, genre.id) => [
			it <=> notNullValue
			id <=> genre.id
			name <=> genre.name
		]
	}
}