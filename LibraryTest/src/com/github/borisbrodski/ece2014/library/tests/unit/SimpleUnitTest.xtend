package com.github.borisbrodski.ece2014.library.tests.unit

import com.github.borisbrodski.ece2014.library.testtools.UnitTestRule
import org.junit.Rule
import org.junit.Test
import static extension org.eclipse.xtend.jmockit.JMockitExtension.*

class UnitTest {
	@Rule
	public extension UnitTestRule = new UnitTestRule

	@Test
	def void test() {
		stub(System) [
			System.getProperty("aaaaa")
			result = "Yahoo"
		]

		System.getProperty("aaaaa") <=> "Yahoo"
	}
}
