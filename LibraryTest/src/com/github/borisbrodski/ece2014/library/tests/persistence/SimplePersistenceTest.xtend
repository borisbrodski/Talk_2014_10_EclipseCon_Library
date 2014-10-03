package com.github.borisbrodski.ece2014.library.tests.persistence

import com.github.borisbrodski.ece2014.library.testtools.PersistenceTestRule
import org.junit.Rule
import org.junit.Test

class SimplePersistenceTest {
	@Rule
	public extension PersistenceTestRule = new PersistenceTestRule
	
	@Test
	def void test() {
		getEntityManager.clear
	}	
}